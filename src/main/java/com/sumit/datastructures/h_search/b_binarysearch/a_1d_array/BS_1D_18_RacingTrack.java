package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_18_RacingTrack {

    // Red Notes Question : Page No - 76

    public static void main(String[] args) {
        BS_1D_18_RacingTrack obj = new BS_1D_18_RacingTrack();

        int[] racingTrack1 = {1,2,4,8,9};
        int numOfKids1 = 2;
        System.out.println("Racing Track : " + Arrays.toString(racingTrack1) + ", numOfKids : "+ numOfKids1 + " => MaximalMinima = " + obj.raceTrack(racingTrack1, numOfKids1));

        int[] racingTrack2 = {1,2,4,8,9};
        int numOfKids2 = 3;
        System.out.println("Racing Track : " + Arrays.toString(racingTrack2) + ", numOfKids : "+ numOfKids2 + " => MaximalMinima = " + obj.raceTrack(racingTrack2, numOfKids2));
    }

    public int raceTrack(int[] track, int numOfKids){
        // if kids are more than track positions then we can have extra kids, so placement is not possible
        if(numOfKids > track.length)
            return -1;

        int start = 1, end = (int) 1e9;
        int possibleAns = -1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            // check if we can place all kids in track, such that kids minimum distance is mid
            boolean isPossible = isPlacementPossible(track, numOfKids, mid);
            if(isPossible){
                possibleAns = mid;
                start = mid+1;
            } else
                end = mid-1;
        }
        return possibleAns;
    }


    // check if we can place all kids in track, such that kids minimum distance is mid
    private boolean isPlacementPossible(int[] track, int numOfKids, int kidsMinDistance) {
        // we placed 1st kid at 0th index of array
        int previousKidPosition = track[0];
        numOfKids--;

        for(int i=1; i< track.length; i++) {

            // because we have already placed all the kids
            if(numOfKids == 0)  return true;

            int currentKidPosition = track[i];
            if(currentKidPosition-previousKidPosition  >=  kidsMinDistance){
                numOfKids--;
                previousKidPosition = currentKidPosition;
            }
        }

        // because we have placed all the kids
        if(numOfKids == 0)
            return true;
        else
            return false;
    }


}