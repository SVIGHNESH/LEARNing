class DecimalToBinary{
  private String convertToBinary(int n ){
    if (n == 0) return "0";
    StringBuilder res = new StringBuilder();
      while(n > 0 ){
                res.append(n%2);
                n = n/2;

      }

    return res.reverse().toString();
  }

  private int ConvertToDecimal(String x){
    int len = x.length();
    int num = 0;
    int p2 = 1;
    for(int i = len - 1 ; i>=0;i--){
      char c =  x.charAt(i);
      if(c == '1'){
            num = num + p2;
      }
                  p2 = p2 * 2; 

    }
    return num;

  }
  private int countSetBits(int n ){
    int cnt = 0; 
    while(n > 1){
      if(n % 2 ==1 ){
        cnt += 1;
      }
      n = n / 2 ; 

    }
          if(n == 1) cnt += 1;

    return cnt;
  }
  public static void main(String[] args) {
     DecimalToBinary obj = new DecimalToBinary();
    System.out.println(obj.convertToBinary(4));
    System.out.println(obj.ConvertToDecimal("111"));
    System.out.println(obj.countSetBits(16));
  }
}
