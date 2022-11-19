class Solution {
    public int romanToInt(String s) {

        char[] breakDown = s.toCharArray();
        int decValue =0;
        int answer =0;
       
        for(int i = 0; i< breakDown.length; i++)
        {
            
            switch (breakDown[i])
            {case 'I':
              {
                  if( i < breakDown.length-1)
                  {
                      if( breakDown[i+1] == 'V')
                      {
                          decValue = 4 ;
                          i++;
                      }
                      else if( breakDown[i+1] == 'X')
                      {
                          decValue = 9 ;
                          i++;
                      }

                      else
                        decValue = 1 ;
              }
              else
              decValue = 1 ;
                  }
                  
            break;
            case 'V':
               decValue = 5;
               break;
            case 'X':
            {
                if( i < breakDown.length-1)
                  {
                      if(breakDown[i+1] == 'C')
                        {decValue = 90;
                         i++;
                        }
                        else if(breakDown[i+1] == 'L')
                        {decValue = 40;
                         i++;
                        }
                      else
                         decValue = 10;
                  }
                  else
                   decValue = 10;
            }
               break;
            case 'L':
            {


               decValue =50;
            }
               break;
            case 'C':
            {
                 if( i < breakDown.length-1)
                  {
                      if(breakDown[i+1] == 'M')
                         {decValue = 900;
                         i++;
                         }
                      else if(breakDown[i+1] == 'D')
                         {decValue = 400;
                         i++;
                         }
                      else
                         decValue = 100;
                  }
                  else 
                   decValue = 100;
            }
               break;
            case 'D':
                decValue = 500;
                break;
            case 'M':
                decValue = 1000;
                break; 
            }


            answer += decValue;
            
        }


        return answer;
    }

    
    
}