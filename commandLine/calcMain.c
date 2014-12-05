#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h> // for open
#include <unistd.h> // for close

#include "resistor.h"
#include "calcPrint.c"
#include "calcHelp.c"


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
    if (resistor->howMany == 3){
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

int main(int argc, char **argv){

    if (argc < 3 || argc > 8 ){
        fprintf(stderr,"Wrong number of args\n");
        showHelp();
        return -1;
    } 
    if (isNumber(argv[1] ) == 0 ){
        fprintf(stderr,"The first argument have to be number [3-6]\n");
        showHelp();
        return -1;
    }

    int howMany = atoi (argv[1]);
    if (howMany < 3 && howMany > 6){
        fprintf(stderr,"Wrong number of stripes \n ERROR see calc -usage");    
        return -1;
        /** Check if howMany and real arguments number matches*/
    }else if (howMany -argc + 2 != 0){
        fprintf(stderr,"ERROR: \n ERROR see calc -usage");    
        return -1;
    } 
    struct Resistor *arg  = malloc (sizeof(struct Resistor));


    if (arg !=NULL){
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

            arg -> howMany = 5; }
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
    beautiFulPrinting(arg);
    summaryPrint(arg);

    free (arg);

    return 0;
}
