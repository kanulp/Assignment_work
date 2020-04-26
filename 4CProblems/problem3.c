#include <stdio.h>
int main() {
    int low, high, i, flag,isFistIteraion=0;
    scanf("%d %d", &low, &high);
    while (low < high) {
        flag = 0;
        for (i = 2; i <= low / 2; ++i) {
            if (low % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            if(isFistIteraion==0){
                isFistIteraion=1;
                printf("%d", low);
            }else{
                printf(",%d",low);
            }
        }
        ++low;
    }
    printf("\n");
    return 0;
}