
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void* threadFunction (void *value)
{

int random_num = 0;
int guessed_num = 0;
int counter = 0;
random_num = rand() % 10 + 1;
    while(1)
    {
        printf("\nGuess the number : \n");
    counter++; 
    scanf("%d", &guessed_num);
    usleep (1000);
    if (guessed_num == random_num) 
    {
        printf("You guessed correctly in %d tries! Congratulations!\n", counter); 
        break;
    }
    
    if (guessed_num < random_num) 
        printf("Your guess is too low. Guess again. ");

    if (guessed_num > random_num) 
        printf("Your guess is too high. Guess again. ");

    }

    //printf("random is %d",random_num);
    
}

int
main ()
{

pthread_t thread; 


if (pthread_create (&thread, NULL, &threadFunction, (void*)NULL) != 0)
{
printf ("Failed to create the thread\n");
return 1;
}
    

void *result; 
pthread_join (thread, &result); 
int *z = (int*) result; 
//printf ("Final retrun : z=%d\n", *z);
return EXIT_SUCCESS;
}
