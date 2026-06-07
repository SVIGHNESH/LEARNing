import java.util.ArrayList;

class HeapImplementation {
  private ArrayList<Integer> data;
  private Integer length;

  // Implementing the MIN-HEAP DATA STRUCTURE
  HeapImplementation() {
    this.data = new ArrayList<>();
    this.length = 0;
  }

  public void insert(Integer value) {
    // just don't do this
    // this.data.set(this.length, value);
    this.data.add(value);
    this.heapifyUp(this.length);
    this.length++;

  }

  public Integer delete() {
    if (this.length == 0) {
      return -1;
    }
    Integer out = this.data.get(0);
    this.length--;
    if (this.length == 0) {
      this.data.clear();
      return out;
    }

    this.data.set(0, this.data.get(this.length));

    heapifyDown(0);

    return out;

  }

  private void heapifyDown(Integer idx) {
    if (idx >= this.length) {
      return;
    }

    Integer lIdx = this.leftChild(idx);

    Integer rIdx = this.rightChild(idx);

    if (idx >= this.length || lIdx >= this.length) {
      return;

    }

    Integer lValue = this.data.get(lIdx);
    Integer rValue = this.data.get(rIdx);
    Integer V = this.data.get(idx);

    if (lValue > rValue && V > rValue) {

      this.data.set(rIdx, V);
      this.data.set(idx, rValue);
      this.heapifyDown(rIdx);
    } else if (rValue > lValue && lValue < V) {

      this.data.set(lIdx, V);
      this.data.set(idx, lValue);
      this.heapifyDown(lIdx);
    }

  }

  private void heapifyUp(Integer idx) {
    if (idx == 0) {
      return;
    }
    Integer p = this.parent(idx);
    Integer parentValue = this.data.get(p);
    Integer currentValue = this.data.get(idx);

    if (parentValue > currentValue) {
      this.data.set(idx, parentValue);
      this.data.set(p, currentValue);
      this.heapifyUp(p);
    }

  }

  private Integer parent(Integer idx) {
    return (int) Math.floor((idx - 1) / 2);
  }

  private Integer leftChild(Integer idx) {
    return 2 * idx + 1;
  }

  private Integer rightChild(Integer idx) {
    return 2 * idx + 2;
  }

  // Driver Code
  public static void main(String[] args) {
    HeapImplementation h = new HeapImplementation();
    h.insert(45);
    h.insert(52);
    h.insert(61);
    h.insert(1);
    System.out.println(h.delete());
    System.out.println(h.delete());
    System.out.println(h.delete());
  }

}
