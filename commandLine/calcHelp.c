#include <stdio.h>

/*This part is responsible for help :)
 */
/*
 * returns 1 if is number
 * returns 0 if is not
 */
int isNumber(char *arg){
   int i = 0;
   while (arg [i] != '\0' ){
    if (arg[i]>'0' || arg[i]<'9')
        return 0;    
   }
    return 1;
}

void showHelp( void ){
  FILE *in;
  
  in = fopen ("helpString", "r");
  if (in == NULL ){
    fprintf(stderr, "Sorry something happened to printHelp file:(\nI cannot print help");
    return;
  }
    
    size_t len;
    char *input = NULL;
    char read;
    while ((read = getline(&input,&len,in)) != -1){
        printf ("%s",input);
    }

  fclose (in);
}
