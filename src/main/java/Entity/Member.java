package Entity;

public class Member {
    private Integer memberId;
    private String name;
    private String memberType;
    private Integer PhoneNumber;

    public Member(Integer memberId, String name, String memberType, Integer phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.memberType = memberType;
        this.PhoneNumber = phoneNumber;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Integer getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
       this.PhoneNumber = phoneNumber;
    }
}
