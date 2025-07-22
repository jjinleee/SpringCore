package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private  final MemberRepository memberRepository= new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member, itemPrice);

        //단일책임원칙을 잘 지킨 설계이다. 만약 할인에 대한 변경만 필요하면 할인만 고치면 되고, 주문변경이면 주문만 변경하면됨

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
