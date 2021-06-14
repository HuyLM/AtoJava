package com.ato.helper;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomHelper {

    private static Random rand =new Random();
    public static <T> T RandomInCollection(ArrayList<T> list, ArrayList<T> blackList)
    {

        if(list == null || list.size() == 0)
        {
            return null;
        }
        T randomValue = null;
        do {
            randomValue = list.get(rand.nextInt(list.size()));
        }
        while (blackList != null && blackList.contains(randomValue));
        return randomValue;
    }

    public static <T> T RandomInCollection(T[] list, T[] blackList)
    {
        if(list == null || list.length == 0)
        {
            return null;
        }
        List<T> blackList1 = null;
        if(blackList != null)
        {
            blackList1 = Arrays.asList(blackList);
        }
        T randomValue = null;
        do {
            randomValue = list[rand.nextInt(list.length)];
        }
        while (blackList1 != null && blackList1.contains(randomValue));
        return randomValue;
    }

    public static <T> ArrayList<T> RandomInCollection(ArrayList<T> array, int number, boolean duplicate, ArrayList<T> blackList)
    {
        if(!duplicate && array.size() < number)
        {
            // Log : Can't Random Collection because out of range
            return null;
        }
        ArrayList<T> result = new ArrayList<>(number);
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        for (int i = 0; i < number; ++i)
        {
            int randomIndex = 0;
            do
            {
                randomIndex = rand.nextInt(array.size());

            } while (blackList != null && blackList.contains(array.get(randomIndex)));
            if (!duplicate)
            {
                while (indexs.contains(randomIndex))
                {
                    randomIndex = rand.nextInt(array.size());
                }
                indexs.add(randomIndex);
            }
            else
            {
                indexs.add(randomIndex);
            }
            result.add(array.get(randomIndex));
        }
        return result;
    }

    public static <T> ArrayList<T> RandomInCollection(T[] array, int number, boolean duplicate, T[] blackList)
    {
        if(!duplicate && array.length < number)
        {
            // Log : Can't Random Collection because out of range
            return new ArrayList<>();
        }
        List<T> blackList1 = null;
        if(blackList != null)
        {
            blackList1 = Arrays.asList(blackList);
        }
        ArrayList<T> result = new ArrayList<>(number);
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        for (int i = 0; i < number; ++i)
        {
            int randomIndex = 0;
            do
            {
                randomIndex = rand.nextInt(array.length);

            } while (blackList1 != null && blackList1.contains(array[randomIndex]));
            if (!duplicate)
            {
                while (indexs.contains(randomIndex))
                {
                    randomIndex = rand.nextInt(array.length);
                }
                indexs.add(randomIndex);
            }
            else
            {
                indexs.add(randomIndex);
            }
            result.add(array[randomIndex]);
        }
        return result;
    }

    public static int RandomNumber(int min, int max)
    {
        return min + rand.nextInt(max - min + 1);
    }

    public static float RandomNumber(float min, float max)
    {
        return min + rand.nextFloat() * (max - min);
    }
}

