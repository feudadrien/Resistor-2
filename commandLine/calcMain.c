#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include "resistor.h"
/* This function changes the string to number (figure) 2 or 3
 * first arguments are base which will be multiplified 
 * 
 */

static char  *Colors[] = {"black","brown","red","orange","yellow","green","blue","violet","grey","white","gold","silver","none",
    "bl","br","re","or","ye","gr","b","vi","gr","wh","go","si","no"};
static int COLORS_NUMBER = 13 ;


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
    struct Resistor *arg  = malloc (sizeof(struct Resistor));
    arg->first = "blue";
    arg->second = "black";
    arg->howMany = 3; 
    printf ("%lld \n",resistance(arg));
    return 0;
}
