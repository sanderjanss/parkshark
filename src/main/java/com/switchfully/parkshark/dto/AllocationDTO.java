package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Allocation;

import java.time.LocalDateTime;

public class AllocationDTO {
    private int allocationId;
    private MemberDTO member;
    private ParkingLotDTO parkingLot;
    private LocalDateTime startHour;
    private LocalDateTime endHour;
    private Allocation.AllocationStatus status;

    public AllocationDTO(int allocationId, MemberDTO member, ParkingLotDTO parkingLot, LocalDateTime startHour, LocalDateTime endHour, Allocation.AllocationStatus status) {
        this.allocationId = allocationId;
        this.member = member;
        this.parkingLot = parkingLot;
        this.startHour = startHour;
        this.endHour = endHour;
        this.status = status;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public MemberDTO getMember() {
        return member;
    }

    public ParkingLotDTO getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public LocalDateTime getEndHour() {
        return endHour;
    }

    public Allocation.AllocationStatus getStatus() {
        return status;
    }

    public static final class Builder {
        private int allocationId;
        private MemberDTO member;
        private ParkingLotDTO parkingLot;
        private LocalDateTime startHour;
        private LocalDateTime endHour;
        private Allocation.AllocationStatus status;

        private Builder() {
        }

        public static Builder anAllocationDTO() {
            return new Builder();
        }

        public Builder withAllocationId(int allocationId) {
            this.allocationId = allocationId;
            return this;
        }

        public Builder withMember(MemberDTO member) {
            this.member = member;
            return this;
        }

        public Builder withParkingLot(ParkingLotDTO parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder withStartHour(LocalDateTime startHour) {
            this.startHour = startHour;
            return this;
        }

        public Builder withEndHour(LocalDateTime endHour) {
            this.endHour = endHour;
            return this;
        }

        public Builder withStatus(Allocation.AllocationStatus status) {
            this.status = status;
            return this;
        }

        public AllocationDTO build() {
            return new AllocationDTO(allocationId, member, parkingLot, startHour, endHour, status);
        }
    }
}