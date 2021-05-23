#include <iostream>
using namespace std;

  struct ListNode {
    int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
 
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head==NULL){
            return NULL;
        }
        ListNode* odd = head;
         ListNode* even = head->next;
         ListNode* tempHead1 = odd;
        ListNode* tempHead2 = even;
        
        
        while(even && even->next){
            odd->next = even->next;
            odd = even->next;
            even->next = odd->next;
            even = odd->next;
        }
        
        odd->next = tempHead2;
        head =tempHead1;
        
        return head;
        
    }
};