#include <arpa/inet.h> // For inet_addr and inet_ntoa
#include <stdio.h>
void calculate_subnet(char *ip_str, int cidr) {
  uint32_t ip, mask, network, broadcast;
  struct in_addr addr;
  // 1. Convert IP string to 32-bit integer (Network Byte Order)
  ip = ntohl(inet_addr(ip_str));
  // 2. Create the Subnet Mask using CIDR
  // Shift 1s to the left, then fill the rest with 0s
  if (cidr == 0)
    mask = 0;
  else
    mask = ~((1 << (32 - cidr)) - 1);
  // 3. Calculate Network and Broadcast addresses
  network = ip & mask;
  broadcast = network | (~mask);
  // 4. Output Results
  printf("IP Address:%s\n", ip_str);
  addr.s_addr = htonl(mask);
  printf("Subnet Mask:%s (/%d)\n", inet_ntoa(addr), cidr);
  addr.s_addr = htonl(network);
  printf("Network Address: %s\n", inet_ntoa(addr));
  addr.s_addr = htonl(broadcast);
  printf("Broadcast Addr: %s\n", inet_ntoa(addr));
  addr.s_addr = htonl(network + 1);
  printf("First Host:%s\n", inet_ntoa(addr));
  addr.s_addr = htonl(broadcast - 1);
  printf("Last Host:%s\n", inet_ntoa(addr));
}
int main() {
  char ip[20];
  int cidr;
  printf("Enter IP Address (e.g., 192.168.1.10): ");
  scanf("%s", ip);
  printf("Enter CIDR (e.g., 24): ");
  scanf("%d", &cidr);
  printf("\n--- Subnet Results ---\n");
  calculate_subnet(ip, cidr);
  return 0;
}
