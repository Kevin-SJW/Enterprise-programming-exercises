package AutumnRecruitment;

import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution2
{
    public static Boolean Prize(String prizeTicket, String ticket, int index)
{
    if (index==ticket.length())
    {
        if (prizeTicket.contains(ticket))
        {
            return true;
        }
        for (int i = 0; i < ticket.length(); i++)
        {
            if (prizeTicket.contains(ticket.substring(i,1)))
                return true;
        }
        return false;
    }

    char[] charArray = ticket.toCharArray();
    Boolean result = false;
    //不变
    result = Prize(prizeTicket, ticket, index + 1);
    if (result)
    {
        return true;
    }
    //修改
    if (charArray[index]=='o')
    {
        charArray[index] = 'a';
    }
    else if (charArray[index]=='t')
    {
        charArray[index] = 'l';
    }
    else if (charArray[index] == 'a')
    {
        charArray[index] = 'o';
    }
    else if (charArray[index] == 'l')
    {
        charArray[index] = 't';
    }
    result = Prize(prizeTicket, new String(charArray), index + 1);
    if (result)
    {
        return true;
    }
    return false;
}
    public static int getNoOfWinners(int numTickets,String drawString,List<String> tickets)
    {
        int result = 0;
        for(String ticket:tickets)
        {
            if (Prize(drawString, ticket, 0))
            {
                result++;
            }
        }
        return result;
    }
}