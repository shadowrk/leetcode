package easylist;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;  //Represents the maximum number of flowers that can be planted.

        if(flowerbed == null || flowerbed.length == 0)
            return sum == n;
        if(flowerbed.length == 1)
        {
            if(flowerbed[0] == 0)
            {
                sum++;
                return sum >= n;       //we use >= because n can be less than the max number of plants and
            }                          //still is valid (plantable on the flowerbed)
            else
                return sum >= n;
        }

        //Calcualte the maximum number of flowers we can plant
        for(int i =0; i < flowerbed.length; i++)
        {
            if( flowerbed[i] == 0)
            {
                if(i == 0) //checks if first element
                {
                    if(flowerbed[i+1] == 0)
                    {
                        sum++;
                        flowerbed[i] = 1;
                    }
                }
                else if( i == flowerbed.length-1)   //checks if last element
                {
                    if(flowerbed[i-1] == 0)
                    {
                        sum++;
                        flowerbed[i] = 1;
                    }
                }
                else
                {
                    if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0)  //middle element checks adjacent side left and right of it.
                    {
                        sum++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return sum>=n;
    }
}
