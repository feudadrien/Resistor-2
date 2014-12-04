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

char *colorToMulti(int arg){
    if (arg==0) return "1 OHM";                             //black
    else if (arg ==1) return "10 OHM";                      //brown
    else if (arg ==2) return "100 OHM";                     //red
    else if (arg ==3) return "1K OHM";                      //orange
    else if (arg ==4) return "10K OHM";                     //yellow
    else if (arg ==5) return "100K OHM";                    //green
    else if (arg ==6) return "1M OHM";                      //blue
    else if (arg ==7) return "10M OHM";                     //violet
    else if (arg ==8) return "THERE IS NO SUCH MULTIPLER";  //grey
    else if (arg ==9) return "THERE IS NO SUCH MULTIPLER";  //white
    else if (arg ==10) return "0.1 OHM";                    //gold 
    else if (arg ==11) return "0.01 OHM";                   //silver
    else if (arg ==12) return "no";                         //none
    else return "FU";   // FU -eq FuckYou there is no such color ;v 
    return NULL; 
}

char *colorToTolerance(int arg){
    if (arg==0) return "(+/-)1 %";                          //black
    else if (arg ==1) return "(+/-)1 %";                    //brown
    else if (arg ==2) return "(+/-)1 %";                    //red
    else if (arg ==3) return "THERE IS NO SUCH TOLERANCE";  //orange
    else if (arg ==4) return "THERE IS NO SUCH TOLERANCE";  //yellow
    else if (arg ==5) return "(+/-)0.5 %";                  //green
    else if (arg ==6) return "(+/-)0.25 %";                 //blue
    else if (arg ==7) return "(+/-)0.10 %";                 //violet
    else if (arg ==8) return "(+/-)0.05 %";                 //grey
    else if (arg ==9) return "THERE IS NO SUCH TOLERANCE";  //white
    else if (arg ==10) return "(+/-)5 %";                   //gold 
    else if (arg ==11) return "(+/-)10 %";                  //silver
    else if (arg ==12) return "no";                         //none
    else return "FU";   // FU -eq FuckYou there is no such color ;v 
    return NULL; 
}

char *colorIntToColorString(int arg){
    if (arg==0) return "bl";        //black
    else if (arg ==1) return "br";  //brown
    else if (arg ==2) return "re";  //red
    else if (arg ==3) return "or";  //orange
    else if (arg ==4) return "ye";  //yellow
    else if (arg ==5) return "gr";  //green
    else if (arg ==6) return "bb";  //blue
    else if (arg ==7) return "vi";  //violet
    else if (arg ==8) return "gr";  //grey
    else if (arg ==9) return "wh";  //white
    else if (arg ==10) return "go"; //gold 
    else if (arg ==11) return "si"; //silver
    else if (arg ==12) return "no"; //none
    else return "FU"; // FU -eq FuckYou there is no such color :D
}


void summaryPrint(struct Resistor *arg){
    int howMany = arg->howMany;
    char *multiplier,*tolerance,*somethingWhatIdontRemeber;
    int baseResistance; 
    if (howMany > 2){
        baseResistance =  arg->baseResistance;
        
    } if (howMany > 3)
    ;
    if (howMany > 4)
    ; 
    if (howMany > 5)
    ;

}


void beautiFulPrinting(struct Resistor *arg){
    FILE *in;
    in = fopen ("printString","r");
    if (in == NULL){
        fprintf(stderr, "Sorry guy something happend to printString file :(!!\nI cannot print resistor");
        return;
    }
    int howMany = arg->howMany;

    char *first,*second,*third,*fourth,*fifth,*sixth;
#ifdef Debug
    printf("##DEBUG %d\n",arg->howMany);
#endif
    if (howMany > 2){
        first = colorIntToColorString(stringToBase2( arg->first));
        second = colorIntToColorString(stringToBase2 (arg->second));
        fourth = colorIntToColorString(stringToBase2 (arg->fourth));
        third ="  ";
        fifth = "  ";
        sixth = "  ";  
    } if (howMany > 3)
    third = colorIntToColorString(stringToBase2 (arg->third));
    if (howMany > 4)
        fifth = colorIntToColorString(stringToBase2 (arg->fifth));
    if (howMany > 5)
        sixth = colorIntToColorString(stringToBase2 (arg->sixth));


    /* Here goes printing*/
    size_t len; 
    char read; 
    char *input = NULL;
    while ((read = getline(&input, &len, in)) != -1) {
        // printf("Retrieved line of length %s :\n", &read);
        int i; 
        for ( i = 0 ; i < (int)len;i++){

            if(input [i] == '1'){
                input[i]=first[0];
                ++i;
                input[i]=first[1];
            }else if(input [i] == '2'){
                input[i]=second[0];
                ++i;
                input[i]=second[1];
            }else if(input [i] == '3'){
                input[i]=third[0];
                ++i;
                input[i]=third[1];
            }else if(input [i] == '4'){
                input[i]=fourth[0];
                ++i;
                input[i]=fourth[1];
            }else if(input [i] == '5'){
                input[i]=fifth[0];
                ++i;
                input[i]=fifth[1];
            }else if(input [i] == '6'){
                input[i]=sixth[0];
                ++i;
                input[i]=sixth[1];
            }



        }
        printf("%s", input);
    }
    /* Cleaning*/


    fclose(in);

}

