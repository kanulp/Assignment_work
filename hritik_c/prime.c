#include<stdio.h>
float Find_median(int array[] , int n)
{
    float median=0;
    if(n%2 == 0)
        median = (array[(n-1)/2] + array[n/2])/2.0;
    else
        median = array[n/2];
    return median;
}
int main() {

   int arr[20], i, s, j, p,t,prime[20],k=0,sum=0;

   printf("Enter Size of An Array :");
   scanf("%d", &s);

   printf("\nEnter Array Elements :");
   for (i = 0; i < s; i++) {
       scanf("%d", &arr[i]);
   }


   for (i = 0; i < s; i++) {
       j = 2;
       p = 1;
       while (j < arr[i]) {
           if (arr[i] % j == 0) {
               p = 0;
               break;
           }
           j++;
       }
       if (p == 1) {
           //printf("%d ", arr[i]);
           prime[k++]=arr[i];
       }
   }
   
   printf("Sorted Prime numbers : ");
   for(i=0;i<k-1;i++)
          for(j=i+1;j<k;j++)
               if(prime[i]<prime[j])
               {
                    t=prime[i];
                    prime[i]=prime[j];
                    prime[j]=t;
               }
  
	for(i=0;i<k;i++){
    sum = sum + prime[i];
		 printf("%d ", prime[i]);
	}
  printf("\nSum of array is : %d",sum);
  float m = Find_median(prime,k);
  printf("\nMedian is %f ",m);
   return 0;
}