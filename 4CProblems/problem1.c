#include<stdio.h>
int main(){
     int k,m,n;
     scanf("%d",&k);
     
     int arr1[k];
     for (int i = 0; i < k; i++)
     {
         scanf("%d",&arr1[i]);
     }
     scanf("%d",&m);
     int arr2[m];
     for (int i = 0; i < m; i++)
     {
         scanf("%d",&arr2[i]);
     }
    scanf("%d",&n);

    if(n>k || n>m){
        printf("INVALID\n");
        return 0;
    }

    int flagEqual=0, flagGreater=0,flagLess=0;

    for (int i = 0; i < n; i++)
    {
        if(arr1[i]==arr2[i])
            flagEqual++;
        if(arr1[i]>arr2[i])
            flagGreater++;
        if(arr1[i]<arr2[i])
            flagLess++;
    }

    if(flagEqual==n){
        printf("EQUAL\n");
        return 0;
    }
    else if(flagGreater==n){
        printf("LARGER\n");
        return 0;
    }
    else if(flagLess==n){
        printf("SMALLER\n");
        return 0;
    }
    else {
        printf("NONE\n");
    }

    return 0;
}