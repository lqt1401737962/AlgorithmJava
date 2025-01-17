package com.qitong;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
示例 1:
    输入: "()"
    输出: true
示例 2:
    输入: "()[]{}"
    输出: true
示例 3:
    输入: "(]"
    输出: false
示例 4:
    输入: "([)]"
    输出: false
示例 5:
    输入: "{[]}"
    输出: true
 */
public class 有效括号 {
    private static final Map<Character,Character> map=new HashMap<Character,Character>();

    public static  boolean isValid(String s){
        map.put('(',')');map.put('[',']');map.put('{','}');map.put('?','?');
        if (s.length()%2==1||s.length()==0)  return  false;
        Stack<Character> st = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) st.push(chars[i]);
            else{
                Character pop = st.pop();
                Character c = chars[i];
                if (c.equals(pop))return false;
            }
        }
        return st.size()==0;
    }

    public static void main(String[] args) {
        boolean v = isValid("{()}{{}");
        System.out.println(v);
        System.out.println("isValid(\"{[}\") = " + isValid("{[()]}"));
        System.out.println("isValid(\"\") = " + isValid(""));
    }

}
