#include <iostream>
using namespace std;

int ls(int arr[],int n , int key){
    int s = 0;
    int e = n-1;
    while(s<=e){
        int mid = (s+e)/2;
        if(arr[mid]==key){
            return mid;
        }else if(arr[mid]<key){
            s=mid+1;
        }else{
            e=mid-1;
        }
    }
    return -1;
}
int main(){
    int arr[]={10,20,30,40};
    int key =40;
    cout<<ls(arr,4,key);
}