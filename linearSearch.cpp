#include <iostream>
using namespace std;
 int ls(int arr[], int key , int n){
        for(int i=0;i<=n;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
int main(){
    int arr[]={10,20,30,40,50};
    int key = 40;
    cout<<ls(arr,50,5);
}
