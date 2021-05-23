#include <iostream>
using namespace std;

  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* temp = node->next;
        node->next = temp->next;
        
        node->val = temp->val;
        temp->next = NULL;
        
    }
};