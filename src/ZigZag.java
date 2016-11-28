/**
 *A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.

 For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive and the second because its last difference is zero.

 Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
 */
public class ZigZag {
    public static int longestZigZag(int[] sequence)
    {
        if(sequence.length == 1) return 1;
        int[] v = new int[sequence.length-1];
        for(int i=1;i<sequence.length;i++)
        {
            v[i-1] = sequence[i] - sequence[i-1];
        }
        //    dir is first nonzero
        int ii=0;
        while( ii < v.length && v[ii] == 0)
            ii++;
        if(ii == v.length) return 1;
        int dir = v[ii];
        int len = 2;
        for(int i=ii+1;i<v.length;i++)
        {
            if(v[i] * dir < 0)
            {
                dir *= -1;
                len++;
            }
        }
        return len;
    }
}
