#include <stdio.h>
/* This file will make printing 
 * Firstly I wanted colors in terminal, but it's quite complicated
 * and not all colors are easly avaiable*/

extern char  *Colors[]; 

int stringToBase2(char *arg){
    int i;
    for (i = 0; i < 13; ++i){
        if( strcmp (arg,Colors[i]) == 0 || strcmp (arg,Colors[i+13]) == 0 )
            return i; 
    } 
    return -1;
}


char * colorIntToColorString(int arg){
    if (arg==0) return "bl";        //black
    else if (arg ==1) return "br";  //brown
    else if (arg ==2) return "re";  //red
    else if (arg ==3) return "or";  //orange
    else if (arg ==4) return "ye";  //yellow
    else if (arg ==5) return "gr";  //green
    else if (arg ==6) return "b";  //blue
    else if (arg ==7) return "vi";  //violet
    else if (arg ==8) return "gr";  //grey
    else if (arg ==9) return "wh";  //white
    else if (arg ==10) return "go"; //gold 
    else if (arg ==11) return "si"; //silver
    else if (arg ==12) return "no"; //none
    else return "FU"; // FU -eq FuckYou there is no such color :D
}


void beautiFulPrinting(struct Resistor *arg){
//#ifdef DEBUG
    printf("I'm in beautifulPrinting\n");
//#endif
    FILE *in;
    in = fopen ("printString","r");
        if (in == NULL){
            fprintf(stderr, "Sorry guy something happend to printString file :(!!\nI cannot print resistor");
            return;
        }
    int howMany = arg->howMany;

    char *first,*second,*third,*fourth,*fifth,*sixth;


    if (howMany == 3){
        first = colorIntToColorString(stringToBase2( arg->first));
        second = colorIntToColorString(stringToBase2 (arg->second));
        fourth = colorIntToColorString(stringToBase2 (arg->fourth));
        third =" ";
        fourth = " ";
        fifth = " ";
        sixth = " ";  
    } else if (howMany > 3)
        third = colorIntToColorString(stringToBase2 (arg->third));
      else if (howMany > 4)
        fifth = colorIntToColorString(stringToBase2 (arg->fifth));
      else if (howMany > 5)
        sixth = colorIntToColorString(stringToBase2 (arg->sixth));
    /* Here goes printing*/
    size_t *len; 
    char read; 
    char *input = NULL;
    while ((read = getline(&input, len, in)) != -1) {
            printf("Retrieved line of length %s :\n", &read);
                printf("%s", input);
    }


    /*here goes Summary*/

    if (input)
        free(input);
    fclose (in);
    if (in)
        free (in);
}

