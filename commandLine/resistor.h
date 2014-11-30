struct Resistor{
    /* This one shouldn't be changed after inicializaton */ 
    int  howMany;
    char *first;    // First digi 
    char *second;   // Second digit
    char *third;    // Third digit 
    char *fourth;   // Fourth is always multiplekser !!!
    char *fifth;    // Tolrance
    char *sixth;    // Six might be
    /* this one should be changded*/
    double resistanceRounded;
    int baseResistance;
    long long base; // if base is 0.1(-1) or 0.01(-2) 
    char *MultiPlekser;
};
