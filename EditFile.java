package javaapplication14;

/**
 * 
 */
public class EditFile implements Stemmer {

    String[] vowels = new String[]{"a","e","i","o","u","y"};
    String[] doubles = new String[]{"bb","dd","ff","gg","mm","nn","pp","rr","tt"};
    String[] liending = new String[]{"c","d","e","g","h","k","m","n","r","t"};


    @Override
    public String stem(String string) {
        string = string.toLowerCase();
        if(string.length() <= 2){
            return string;
        }

        String newString = initialSettings(string);

        String R1 = "";
        R1 = findR1(newString);
        String R2 = "";
        R2 = findR2(R1);

        String result;

        result = stepZero(newString);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepOneA(result);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepOneB(result,R1);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepOneC(result);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepTwo(result,R1);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepThree(result , R1 , R2);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepFour(result, R2);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = stepFive(result, R1 , R2);
        R1 = findR1(result);
        R2 = findR2(R1);

        result = endSettings(result);

        return result;
    }

    private String endSettings(String result) {
        return result.replaceAll("Y","y");
    }

    private String stepFive(String result , String R1 , String R2) {
        if(result.endsWith("e")){
            if(R1.endsWith("e") || R2.endsWith("e")){
                String syl = result.substring(result.length()-4,result.length()-1);
                if(!isShortSyllabe(syl)){
                    return result.substring(0,result.length()-1);
                }
            }
        }
        if(result.endsWith("l")){
            if(R2.endsWith("l")){
                return (result.charAt(result.length()-2) == 'l')? result.substring(0,result.length()-1): result;
            }
        }
        return result;
    }

    private String stepFour(String result , String R2) {
        if(result.endsWith("ement") && R2.endsWith("ement")){
            return result.substring(0,result.length() - 5);
        }
        if(result.endsWith("ment") && R2.endsWith("ment")){
            return result.substring(0, result.length() - 4);
        }
        if(result.endsWith("ible") && R2.endsWith("ible")){
            return result.substring(0, result.length() - 4);
        }
        if(result.endsWith("able") && R2.endsWith("able")){
            return result.substring(0, result.length() - 4);
        }
        if(result.endsWith("ence") && R2.endsWith("ence")){
            return result.substring(0, result.length() - 4);
        }
        if(result.endsWith("ance") && R2.endsWith("ance")){
            return result.substring(0, result.length() - 4);
        }
        if(result.endsWith("ant") && R2.endsWith("ant")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ent") && R2.endsWith("ent")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ism") && R2.endsWith("ism")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ate") && R2.endsWith("ate")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("iti") && R2.endsWith("iti")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ous") && R2.endsWith("ous")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ive") && R2.endsWith("ive")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ize") && R2.endsWith("ize")){
            return result.substring(0, result.length() - 3);
        }
        if(result.endsWith("ion") && R2.endsWith("ion")){
            return (result.charAt(result.length() - 4) == 's' || result.charAt(result.length() - 4) == 't')? result.substring(0,result.length() - 3) : result;
        }
        if(result.endsWith("ic") && R2.endsWith("ic")){
            return result.substring(0, result.length() - 2);
        }
        if(result.endsWith("er") && R2.endsWith("er")){
            return result.substring(0, result.length() - 2);
        }
        if(result.endsWith("al") && R2.endsWith("al")){
            return result.substring(0, result.length() - 2);
        }
        return result;
    }

    private String stepThree(String result, String R1 , String R2) {
        if(result.endsWith("ational") && R1.endsWith("ational")){
            return result.substring(0,result.length() - 7).concat("ate");
        }
        if(result.endsWith("tional") && R1.endsWith("tional")){
            return result.substring(0,result.length() - 6).concat("tion");
        }
        if(result.endsWith("alize") && R1.endsWith("alize")){
            return result.substring(0,result.length() - 5).concat("al");
        }
        if(result.endsWith("icate") && R1.endsWith("icate")){
            return result.substring(0,result.length() - 5).concat("ic");
        }
        if(result.endsWith("iciti") && R1.endsWith("iciti")){
            return result.substring(0,result.length() - 5).concat("ic");
        }
        if(result.endsWith("ative") && R1.endsWith("ative")){
            return (R2.endsWith("ative"))? result.substring(0,result.length() - 5) : result; // delete if in R2
        }
        if(result.endsWith("ness") && R1.endsWith("ness")){
            return result.substring(0,result.length() - 4);
        }
        if(result.endsWith("ical") && R1.endsWith("ical")){
            return result.substring(0,result.length() - 4).concat("ic");
        }
        if(result.endsWith("ful") && R1.endsWith("ful")){
            return result.substring(0,result.length() - 3);
        }
        return result;
    }

    private String stepTwo(String result, String R1) {
        if(result.endsWith("ization") && R1.endsWith("ization")){
            return result.substring(0,result.length() - 7).concat("ize");
        }
        if(result.endsWith("fulness") && R1.endsWith("fulness")){
            return result.substring(0,result.length() - 7).concat("ful");
        }
        if(result.endsWith("ousness") && R1.endsWith("ousness")){
            return result.substring(0,result.length() - 7).concat("ous");
        }
        if(result.endsWith("iveness") && R1.endsWith("iveness")){
            return result.substring(0,result.length() - 7).concat("ive");
        }
        if(result.endsWith("ational") && R1.endsWith("ational")){
            return result.substring(0,result.length() - 7).concat("ate");
        }
        if(result.endsWith("tional") && R1.endsWith("tional")){
            return result.substring(0,result.length() - 6).concat("tion");
        }
        if(result.endsWith("biliti") && R1.endsWith("biliti")){
            return result.substring(0,result.length() - 6).concat("ble");
        }
        if(result.endsWith("lessli") && R1.endsWith("lessli")){
            return result.substring(0,result.length() - 6).concat("less");
        }
        if(result.endsWith("entli") && R1.endsWith("entli")){
            return result.substring(0,result.length() - 5).concat("ent");
        }
        if(result.endsWith("ation") && R1.endsWith("ation")){
            return result.substring(0,result.length() - 5).concat("ate");
        }
        if(result.endsWith("alism") && R1.endsWith("alism")){
            return result.substring(0,result.length() - 5).concat("al");
        }
        if(result.endsWith("aliti") && R1.endsWith("aliti")){
            return result.substring(0,result.length() - 5).concat("al");
        }
        if(result.endsWith("ousli") && R1.endsWith("ousli")){
            return result.substring(0,result.length() - 5).concat("ous");
        }
        if(result.endsWith("iviti") && R1.endsWith("iviti")){
            return result.substring(0,result.length() - 5).concat("ive");
        }
        if(result.endsWith("fulli") && R1.endsWith("fulli")){
            return result.substring(0,result.length() - 5).concat("ful");
        }
        if(result.endsWith("enci") && R1.endsWith("enci")){
            return result.substring(0,result.length() - 4).concat("ence");
        }
        if(result.endsWith("anci") && R1.endsWith("anci")){
            return result.substring(0,result.length() - 4).concat("ance");
        }
        if(result.endsWith("abli") && R1.endsWith("abli")){
            return result.substring(0,result.length() - 4).concat("able");
        }
        if(result.endsWith("izer") && R1.endsWith("izer")){
            return result.substring(0,result.length() - 4).concat("ize");
        }
        if(result.endsWith("ator") && R1.endsWith("ator")){
            return result.substring(0,result.length() - 4).concat("ate");
        }
        if(result.endsWith("alli") && R1.endsWith("alli")){
            return result.substring(0,result.length() - 4).concat("al");
        }
        if(result.endsWith("bli") && R1.endsWith("bli")){
            return result.substring(0,result.length() - 3).concat("ble");
        }
        if(result.endsWith("ogi") && R1.endsWith("ogi")){
            return (result.charAt(result.length()-4) == 'l')? result.substring(0,result.length() - 3).concat("og"):result;
        }
        if(result.endsWith("li") && R1.endsWith("li")){
            return (findInLiEnding(String.valueOf(result.charAt(result.length()-3))))? result.substring(0,result.length() - 2) :result;
        }
        return result;
    }

    private String stepOneC(String result) {
        boolean flag = result.endsWith("y") || result.endsWith("Y");
        flag &= (!findInVowels(String.valueOf(result.charAt(result.length()-2)))) & (result.length() > 2 );
        return (flag) ? result.substring(0,result.length()-1).concat("i"):result;
    }

    private String stepOneB(String result, String R1) {
        int index;
        if(result.endsWith("eedly")&& R1.endsWith("eedly")){
                index = result.lastIndexOf("eedly");
                return result.substring(0,index).concat("ee");
        }
        if(result.endsWith("ingly")&& R1.endsWith("ingly")){
            boolean flag = false;
            for(int i = 0 ; i < result.length() - 5 ; i++){
                if(findInVowels(String.valueOf(result.charAt(i)))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                boolean tempflag = result.substring(0,result.length() - 5).endsWith("at");
                tempflag |= result.substring(0,result.length() - 5).endsWith("bl");
                tempflag |= result.substring(0,result.length() - 5).endsWith("iz");
                if(tempflag){
                    return result.substring(0,result.length()-5).concat("e");
                }
                tempflag |= findInDoubles(result.substring(result.length()-2));
                if(tempflag){
                    return result.substring(0,result.length() - 1);
                }
                tempflag |= isShortWord(result);
                if(tempflag){
                    return result.concat("e");
                }
            }
            return (flag)? result.substring(0,result.length()-5):result;
        }
        if(result.endsWith("edly")&& R1.endsWith("edly")){
            boolean flag = false;
            for(int i = 0 ; i < result.length() - 4 ; i++){
                if(findInVowels(String.valueOf(result.charAt(i)))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                boolean tempflag = result.substring(0,result.length() - 4).endsWith("at");
                tempflag |= result.substring(0,result.length() - 4).endsWith("bl");
                tempflag |= result.substring(0,result.length() - 4).endsWith("iz");
                if(tempflag){
                    return result.substring(0,result.length()-4).concat("e");
                }
                tempflag |= findInDoubles(result.substring(result.length()-2));
                if(tempflag){
                    return result.substring(0,result.length() - 1);
                }
                tempflag |= isShortWord(result);
                if(tempflag){
                    return result.concat("e");
                }
            }
            return (flag)? result.substring(0,result.length()-4):result;
        }
        if(result.endsWith("eed")&& R1.endsWith("eed")){
            index = result.lastIndexOf("eed");
            return result.substring(0,index).concat("ee");
        }
        if(result.endsWith("ing")&& R1.endsWith("ing")){
            boolean flag = false;
            for(int i = 0 ; i < result.length() - 3 ; i++){
                if(findInVowels(String.valueOf(result.charAt(i)))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                boolean tempflag = result.substring(0,result.length() - 3).endsWith("at");
                tempflag |= result.substring(0,result.length() - 3).endsWith("bl");
                tempflag |= result.substring(0,result.length() - 3).endsWith("iz");
                if(tempflag){
                    return result.substring(0,result.length()-3).concat("e");
                }
                tempflag |= findInDoubles(result.substring(result.length()-2));
                if(tempflag){
                    return result.substring(0,result.length() - 1);
                }
                tempflag |= isShortWord(result);
                if(tempflag){
                    return result.concat("e");
                }
            }
            return (flag)? result.substring(0,result.length()-3):result;

        }
        if(result.endsWith("ed")&& R1.endsWith("ed")){
            boolean flag = false;
            for(int i = 0 ; i < result.length() - 2 ; i++){
                if(findInVowels(String.valueOf(result.charAt(i)))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                boolean tempflag = result.substring(0,result.length() - 2).endsWith("at");
                tempflag |= result.substring(0,result.length() - 2).endsWith("bl");
                tempflag |= result.substring(0,result.length() - 2).endsWith("iz");
                if(tempflag){
                    return result.substring(0,result.length()-2).concat("e");
                }
                tempflag |= findInDoubles(result.substring(result.length()-2));
                if(tempflag){
                    return result.substring(0,result.length() - 1);
                }
                tempflag |= isShortWord(result);
                if(tempflag){
                    return result.concat("e");
                }
            }
            return (flag)? result.substring(0,result.length()-2):result;
        }
        return result;
    }

    private String stepOneA(String result) {
        int index;
        if(result.endsWith("sses")){
            index = result.indexOf("sses");
            return result.substring(0,index).concat("ss");
        }
        if(result.endsWith("ies") || result.endsWith("ied")){
            index = (result.lastIndexOf("ies")!= -1 )? result.lastIndexOf("ies") : result.lastIndexOf("ied");
            if(result.substring(0,index).length() > 1){
                return result.substring(0,index).concat("i");
            }
            else{
                return result.substring(0,index).concat("ie");
            }
        }
        if(result.endsWith("us") || result.endsWith("ss")){
            return result;
        }
        if(result.endsWith("s")){
            index = result.lastIndexOf("s");
            boolean flag = findInVowels(String.valueOf(result.charAt(index - 1)));
            if(flag){
                return result;
            }
            return result.substring(0,index);
        }
        return result;
    }

    private String stepZero(String newString) {
        int index = 0;
        if(newString.endsWith("'s'")){
            index = newString.lastIndexOf("'s'");
            return newString.substring(0,index);
        }
        if(newString.endsWith("'s")){
            index = newString.lastIndexOf("'s");
            return newString.substring(0, index);
        }
        if(newString.endsWith("'")){
            index = newString.lastIndexOf("'");
            return newString.substring(0,index);
        }
        return newString;
    }

    String initialSettings(String string){
        String newString = string;
        if(string.startsWith("'")){
            newString = string.substring(1);
        }
        if(newString.startsWith("y")){
            newString = "Y".concat(newString.substring(1));
        }
        for(int i = 1 ; i < newString.length() ; i++){
            if(newString.charAt(i)=='y' && findInVowels(String.valueOf(newString.charAt(i - 1)))){
                newString = newString.substring(0,i).concat("y").concat(newString.substring(i+1));
            }
        }
        return newString;
    }

    boolean findInVowels(String token){
        for(String s: vowels){
            if(s.equals(token))
                return true;
        }
        return false;
    }

    boolean findInDoubles(String token){
        for(String s: doubles){
            if(s.equals(token))
                return true;
        }
        return false;
    }

    boolean findInLiEnding(String token){
        for(String s: liending){
            if(s.equals(token))
                return true;
        }
        return false;
    }

    private boolean isShortWord(String result) {
        if(result.length() > 2){
            return isShortSyllabe(result.substring(result.length()-3)) &&
                    (findR1(result).equalsIgnoreCase(""));

        }
        else if(result.length() == 2){
            return isShortSyllabe(result) &&
                    (findR1(result).equalsIgnoreCase(""));
        }
        return false;
    }

    private boolean isShortSyllabe(String syllabe){
        boolean tempflag = true;
        if(syllabe.length()==3){
            tempflag &= !findInVowels(String.valueOf(syllabe.charAt(0)));
            tempflag &= findInVowels(String.valueOf(syllabe.charAt(1)));
            tempflag &= !findInVowels(String.valueOf(syllabe.charAt(2)))
                    && ( syllabe.charAt(2) != 'w' || syllabe.charAt(2) != 'x' || syllabe.charAt(2) != 'Y');
            return tempflag;
        }
        else if(syllabe.length()==2){
            tempflag &= findInVowels(String.valueOf(syllabe.charAt(0)));
            tempflag &= !findInVowels(String.valueOf(syllabe.charAt(1)));
            return tempflag;
        }
        return false;
    }

    private String findR1(String newString) {
        String R1="";
        for(int i = 0 ; i < newString.length() - 1 ; i++){
            if(findInVowels(String.valueOf(newString.charAt(i))) && !findInVowels(String.valueOf(newString.charAt(i+1)))){
                R1 = (i + 2 < newString.length() )?newString.substring(i+2) : "";
                return R1;
            }
        }
        return "";
    }

    private String findR2(String R1) {
        String R2="";
        for(int i = 0 ; i < R1.length() - 1 ; i++){
            if(findInVowels(String.valueOf(R1.charAt(i))) && !findInVowels(String.valueOf(R1.charAt(i+1)))){
                R2 = (i + 2 < R1.length() )?R1.substring(i+2) : "";
                return R2;
            }
        }
        return "";
    }
}
