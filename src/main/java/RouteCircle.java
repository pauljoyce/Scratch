public class RouteCircle {
    public boolean judgeCircle(String moves) {
        int x=0, y = 0;
        char[] strings = moves.toCharArray();
        for (int i=0;i<strings.length;i++){
            switch (strings[i]){
                case 'U':
                    y = y + 1;
                    break;
                case 'D':
                    y = y - 1;
                    break;
                case 'L':
                    x = x - 1;
                    break;
                case 'R':
                    x = x + 1;
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        RouteCircle routeCircle = new RouteCircle();
        String ss = "UDLRRL";
        System.out.println(routeCircle.judgeCircle(ss));
    }
}
