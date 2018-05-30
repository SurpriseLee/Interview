package pers.lxs.interview.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class ValidSequences {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        String[] str1 = br.readLine().trim().split(" ");
        int[] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i] = Integer.parseInt(str1[i]);
        }
        int count = 0;
        for(int i = 0;i < n-1;i++){
            if(array[i] > 0){
                for(int j = i+1;j < n;j++){
                    if(array[i] < array[j])
                        count++;
                }
            }
        }
        k -= count;
        List<Integer> indexs = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(array[i] > 0){
                temp.add(array[i]);
            }else{
                indexs.add(i);
            }
        }
        for(int i = 1;i <= n;i++){
            if(!temp.contains(i)){
                values.add(i);
            }
        }
        int res = count(array,indexs,values,k);
        System.out.println(res);
    }
    public static int count(int[] array,List<Integer> indexs,List<Integer> values,int k){
        int count = 0;
        if(indexs.size() == 0){
            if(k == 0)
                return 1;
            else
                return 0;
        }
        int index = indexs.remove(0);
        for(int i = 0;i < values.size();i++){
            int value = values.get(i);
            array[index] = value;
            int pairs = getPairs(array,index);
            if(pairs <= k){
                values.remove(i);
                count += count(array,indexs,values,k-pairs);
                values.add(i,value);
            }
        }
        array[index] = 0;
        indexs.add(0,index);
        return count;
    }
    public static int getPairs(int[] array,int index){
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if((i < index && array[i] < array[index]) || (i > index && array[i] > array[index])){
                count++;
            }
        }
        return count;
    }
}
