package Hackerrank;

import java.util.*;
public class JavaDeque {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int i=0,j=0,tempKey,max=Integer.MIN_VALUE,curr_max=0,now_max=0;
        while(i<m){
            deque.add(arr[i]);
            i++;
        }
        //System.out.println("Deque has " +deque);
        curr_max = getUniqueElemInDeque(deque,map);
        if(curr_max > max)
            max = curr_max;
        //System.out.println("Max is: " + max);
        while(i<n){
            deque.pollFirst();
            deque.add(arr[i]);
            //System.out.println("Deque has " +deque);
            now_max = getUniqueElemInDeque(deque,map);
            //System.out.println("Now Max is:" + now_max);
            if(now_max > max) {
                max = now_max;
            }
            //System.out.println("But Max is:" + max);
            i++;
        }
        //System.out.println(max);
    }

    private static int getUniqueElemInDeque(Deque deque,Map map) {
        int key,x;
        Iterator<Integer> dequeIterator = deque.iterator();
        map.clear();
        while (dequeIterator.hasNext()){
            key = dequeIterator.next();
            if (!map.containsKey(key))
                map.put(key,1);
            else{
                x =  (int)map.get(key);
                map.put(key,x+1);
            }
        }
        //System.out.println("Map Size is:" + map.size());
        return map.size();
    }
}
