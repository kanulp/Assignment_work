
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
  
#define MAX 16 
  
#define MAX_THREAD 4 
  
int a[] = { 1, 5, 7, 10, 12, 14, 15, 18, 20, 22, 25, 27, 30, 64, 110, 220 }; 
  
int key = 100; 
bool found = false; 
int part = 0; 
  
void* binary_search(void* arg) 
{ 
  
    // Each thread checks 1/4 of the array for the key 
    int thread_part = part++; 
    int mid; 
  
    int low = thread_part * (MAX / 4); 
    int high = (thread_part + 1) * (MAX / 4); 
  
    while (low < high && !found)  { 
  
        mid = (high - low) / 2 + low; 
  
        if (a[mid] == key)  { 
            found = true; 
            break; 
        } 
  
        else if (a[mid] > key) 
            high = mid - 1; 
        else
            low = mid + 1; 
    } 
} 
  
  
int main() 
{ 
    pthread_t threads[MAX_THREAD]; 
    
    /* printf("Enter number of elements in array\n");
   scanf("%d", &n);
   printf("Enter %d elements\n", n);
   for (int c = 0; c < n; c++)
      scanf("%d", &a[c]); 
    printf("Enter key to search : ");
    scanf("%d",key);*/
    for (int i = 0; i < MAX_THREAD; i++) 
        pthread_create(&threads[i], NULL, binary_search, (void*)NULL); 
  
    for (int i = 0; i < MAX_THREAD; i++) 
        pthread_join(threads[i], NULL); 
  
    if (found) 
        printf("%d found is array\n",key);
  
    else
        printf("%d not found is array\n",key);

  
    return 0; 
} 