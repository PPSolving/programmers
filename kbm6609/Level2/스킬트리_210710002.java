package Skill_Trees;

public class SkillTrees_210710002 {
    public static void main(String[] args) {
        String skill="CBD";
        String[] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        int answer=0;
        for(int i=0;i< skill_trees.length;i++) {
            StringBuilder str = new StringBuilder(skill);
            boolean flag =true;
            for(char ch : skill_trees[i].toCharArray()) {
                if (skill.contains(String.valueOf(ch))){
                    if(str.indexOf(String.valueOf(ch)) !=0) {
                        flag =false;
                        break;
                    }
                    else str.delete(0,1);
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
