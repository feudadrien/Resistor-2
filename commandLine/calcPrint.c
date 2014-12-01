#include <stdio.h>
#include <resistor.h>
/* This file will make printing 
 * Firstly I wanted colors in terminal, but it's quite complicated
 * and not all colors are easly avaiable*/

static char  *Colors[] = {"black","brown","red","orange","yellow","green","blue","violet","grey","white","gold","silver","none",
    "bl","br","re","or","ye","gr","b","vi","gr","wh","go","si","no"};

long long stringToBase(char *arg){
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


void beautiFulPrinting(struct resistor *arg){
    FILE *in;
    in = fopen ("printString","r")

        int howMany = arg->howMany;
    if (howMany == 3){
         
    }




    fclose (in);
}

