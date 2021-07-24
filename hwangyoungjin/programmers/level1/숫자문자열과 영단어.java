class Solution {
    public int solution(String s) {
        StringBuffer buf = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if( s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                result.append(s.charAt(i)+"");
                continue;    
            }
            
            buf.append(s.charAt(i)+"");
            switch(buf.toString()){
                case "zero":
                    result.append(0+"");
                    buf.delete(0,buf.length());
                    break;
                case "one":
                    result.append(1+"");
                    buf.delete(0,buf.length());
                    break;
                case "two":
                    result.append(2+"");
                    buf.delete(0,buf.length());
                    break;
                case "three":
                    result.append(3+"");
                    buf.delete(0,buf.length());
                    break;
                case "four":
                    result.append(4+"");
                    buf.delete(0,buf.length());
                    break;
                case "five":
                    result.append(5+"");
                    buf.delete(0,buf.length());
                    break;
                case "six":
                    result.append(6+"");
                    buf.delete(0,buf.length());
                    break;
                case "seven":
                    result.append(7+"");
                    buf.delete(0,buf.length());
                    break;
                case "eight":
                    result.append(8+"");
                    buf.delete(0,buf.length());
                    break;
                case "nine":
                    result.append(9+"");
                    buf.delete(0,buf.length());
                    break;
            }
            
        }
        return Integer.parseInt(result.toString());
    }
}