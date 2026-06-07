#include <stdio.h>
#include <stdlib.h>
int main() {
  int frames, i = 1;
  printf("Enter number of frames to send: ");
  scanf("%d", &frames);
  while (i <= frames) {
    printf("\nSender: Sending Frame %d...", i);
    // Simulating ACK reception
    int ack;
    printf("\nReceiver: Received Frame %d. Send ACK? (1 for Yes, 0 for No): ",
           i);
    scanf("%d", &ack);
    if (ack == 1) {
      printf("Sender: ACK %d received. Moving to next frame.\n", i);
      i++;
    } else {
      printf("Sender: Timeout! Retransmitting Frame %d...\n", i);
    }
  }
  printf("\nAll frames sent successfully.\n");
  return 0;
}
