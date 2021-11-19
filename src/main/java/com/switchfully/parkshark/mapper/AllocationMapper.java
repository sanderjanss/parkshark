package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.allocation.AllocationDTO;
import com.switchfully.parkshark.dto.allocation.CreateAllocationDTO;
import com.switchfully.parkshark.dto.member.MemberDTO;
import com.switchfully.parkshark.dto.parkinglot.ParkingLotDTO;
import com.switchfully.parkshark.entity.Allocation;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.exceptions.parkinglot.NoSuchParkingLotException;
import com.switchfully.parkshark.exceptions.member.NoSuchMemberException;
import com.switchfully.parkshark.repository.MemberRepository;
import com.switchfully.parkshark.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllocationMapper {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public AllocationMapper(MemberRepository memberRepository, MemberMapper memberMapper, ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    public Allocation toEntity(CreateAllocationDTO createAllocationDTO) {

        Member member = memberRepository.findMemberByMemberId(createAllocationDTO.getMemberId());
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByParkingLotId(createAllocationDTO.getParkingLotId());

        if (member == null) throw new NoSuchMemberException();
        if (parkingLot == null) throw new NoSuchParkingLotException();

        return new Allocation.Builder()
                .withMember(member)
                .withParkingLot(parkingLot)
                .withStartHour(createAllocationDTO.getStartHour())
                .withStatus(createAllocationDTO.getStatus())
                .build();
    }

    public AllocationDTO toDto(Allocation allocation) {

        MemberDTO memberDTO = memberMapper.toDto(allocation.getMember());
        ParkingLotDTO parkingLotDTO = parkingLotMapper.toDto(allocation.getParkingLot());

        return new AllocationDTO.Builder()
                .withAllocationId(allocation.getAllocationId())
                .withMember(memberDTO)
                .withParkingLot(parkingLotDTO)
                .withStartHour(allocation.getStartHour())
                .withEndHour(allocation.getEndHour())
                .withStatus(allocation.getStatus())
                .build();
    }
}
