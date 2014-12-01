#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include "resistor.h"
#include "calcPrint.c"



char  *Colors[] = {"black","brown","red","orange","yellow","green","blue","violet","grey","white","gold","silver","none",
    "bl","br","re","or","ye","gr","b","vi","gr","wh","go","si","no"};

/* This function changes the string to number (figure) 2 or 3
 * first arguments are base which will be multiplified 
 */
int stringToFigure(char * arg){
#ifdef Debug 
    printf("##DEBUG stringToFigure %s\n",arg);
#endif
    int i ;
    for (i = 0; i < 10; i ++){
        if( strcmp (arg,Colors[i]) == 0 || strcmp (arg,Colors[i+13]) == 0 )
            return i;
    }
    return -1;
}

/* This function change arg to base
 * NOTE: return -1 == 0.1
 * return -2 == 0.001
 * -3 ERR not found
 */
long long stringToBase(char *arg){
    int i;
    long long base = 1;
    for (i = 0; i < 7; ++i){
        if( strcmp (arg,Colors[i]) == 0 || strcmp (arg,Colors[i+13]) == 0 )
            return base;
        base *=10;
    }

    // IF GOLD OR SILVER
        if( strcmp (arg,Colors[11]) == 0 || strcmp (arg,Colors[11+13]) == 0 )
    return -1;
        if( strcmp (arg,Colors[12]) == 0 || strcmp (arg,Colors[12+13]) == 0 )
    return -2; 
    // IF nothing suits there is serious mistake  
    return -3;
}


long long baseResistance(struct Resistor *resistor){
    long long base = stringToBase(resistor->fourth);
    if (base ==-3){
        fprintf(stderr, "SORRY something is bad with multiplekser !!! I quit\n");
       exit(-1);
    }
    if (base >= -3){
           resistor->base = base;
           if (base > 0)
               resistor -> resistanceRounded = (double)base * (double)resistor->baseResistance;          
           else if (base == -2)
                resistor -> resistanceRounded = (double)base * (double)0.01;
           else
                resistor -> resistanceRounded = (double)base * (double)0.1;
       }
       return base; 
}

long long resistance (struct Resistor *resistor){
    long long base = 0; 
    if (resistor->howMany <= 4){
        base += (stringToFigure(resistor->first)*10)+(stringToFigure(resistor->second));
        resistor->baseResistance = base; 
    

        return base;
    }
    else {
        base += (stringToFigure(resistor->first)*100)+(stringToFigure(resistor->second))*10; 
        base += stringToFigure(resistor->third);         
        resistor->baseResistance = base; 
        return base;
    }
    return -1;
}

void additionalInfo(int argc, char ** argv){

}
int main(int argc, char **argv){
    if (argc < 4 || argc > 8){
        fprintf(stderr,"There is wrong number of arguments \n");    
        return -1;
    }
    struct Resistor *arg  = malloc (sizeof(struct Resistor));
    int howMany = atoi (argv[1]);
    if (howMany < 3 && howMany > 6){
        fprintf(stderr,"Wrong number of stripes \n ERROR see calc -usage");    
        return -1;
    }
    else{
        arg ->first = argv[2];
        arg ->second = argv[3];
        arg ->fourth = argv[4];
        arg -> howMany = 3;
        if ( howMany == 4){
            arg ->third = argv[4];
            arg ->fourth = argv[5];
            arg -> howMany = 4;
        }
        else if ( howMany == 5){
            arg ->third = argv[4];
            arg ->fourth = argv[5];
            arg ->fifth = argv [6];

            arg -> howMany = 5;
        }
        else if ( howMany == 6){
            arg ->third = argv[4];
            arg ->fourth = argv[5];
            arg ->fifth = argv [6];
            arg ->sixth = argv[7];
            arg -> howMany = 6;
        }
    }

    resistance(arg);
    baseResistance(arg);     
    fprintf (stderr ,"I'm entering beautifulPrinting\n");
    beautiFulPrinting(arg);
    fprintf (stderr ,"I'm leaving beautifulPrinting\n");
    free (arg);

    return 0;
}
