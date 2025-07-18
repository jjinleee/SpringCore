package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //그냥 레포지토리만 선언하면 null이므로 구현객체를 넣어줘야함
    //memoryMemberRepository에 있는 save 호출됨
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
