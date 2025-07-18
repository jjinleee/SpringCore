package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //그냥 레포지토리만 선언하면 null이므로 구현객체를 넣어줘야함
    //memoryMemberRepository에 있는 save 호출됨

    //실제 할당하는 부분이 구현체를 의존하고 있음. 따라서 구현체에도 의존하고 추상화에도 의존하고 있는 아주 안좋은 상태
    private  final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
