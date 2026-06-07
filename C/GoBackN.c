#include <stdio.h>
int main() {
  int window_size, total_frames, i;
  int next_frame_to_send = 1;
  int ack_received;
  printf("Enter Window Size: ");
  scanf("%d", &window_size);
  printf("Enter Total Frames to send: ");
  scanf("%d", &total_frames);
  while (next_frame_to_send <= total_frames) {
    // Send a window of frames
    for (i = 0; i < window_size && (next_frame_to_send + i) <= total_frames;
         i++) {
      printf("Sender: Sending Frame %d\n", next_frame_to_send + i);
    }
    // Simulate receiving an ACK for the first frame in the window
    printf("\nEnter the last successfully received ACK: ");
    scanf("%d", &ack_received);
    if (ack_received >= next_frame_to_send) {
      // Slide the window to the frame after the ACKed one
      printf("Sender: Sliding window to frame %d\n\n", ack_received + 1);
      next_frame_to_send = ack_received + 1;
    } else {
      printf(
          "Sender: ACK not received/incorrect. Retransmitting window...\n\n");
      // next_frame_to_send stays the same, causing a "Go-Back-N"retransmission
    }
  }
  printf("Success: All frames acknowledged.\n");
  return 0;
}
