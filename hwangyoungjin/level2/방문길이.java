import java.util.*;
class Path{
    int curY;
    int curX;
    int beforeY;
    int beforeX;
    Path(int curY, int curX, int beforeY, int beforeX){
        this.curY = curY;
        this.curX = curX;
        this.beforeY = beforeY;
        this.beforeX = beforeX;
    }
    
    @Override
    public boolean equals(Object o){
        Path p = (Path)o;
        return ((curY == p.curY) && (curX == p.curX) && (beforeY == p.beforeY) && (beforeX == p.beforeX));
    }
    @Override
    public int hashCode(){
        return Objects.hash(curY,curX,beforeY, beforeX);
    }
    
    
}

class Solution {
    public int solution(String dirs) {
        Set<Path> set = new HashSet<>();
        
        int curY = 5;
        int curX = 5;
        int nextY = curY;
        int nextX = curX;
        for(int i=0; i<dirs.length(); i++){
            char ch = dirs.charAt(i);
            curY = nextY;
            curX = nextX;
            switch(ch){
                case 'U':
                    nextY = curY - 1;
                    break;
                case 'D':
                    nextY = curY + 1;
                    break;
                case 'R':
                    nextX = curX + 1;
                    break;
                case 'L':
                    nextX = curX - 1;
                    break;
            }
            if(0 > nextY || nextY > 10 || 0 > nextX || nextX > 10){
                nextY = curY;
                nextX = curX;
                continue;
            }
            set.add(new Path(nextY,nextX,curY,curX));
            set.add(new Path(curY,curX,nextY,nextX));
        }
        return set.size()/2;
    }
}