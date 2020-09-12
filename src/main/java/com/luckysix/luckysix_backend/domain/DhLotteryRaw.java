package com.luckysix.luckysix_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "dh_lottery_raw")
public class DhLotteryRaw {
    @Id
    @Column(name = "round")
    private int round;
    @Column(name = "no_1")
    private int no1;
    @Column(name = "no_2")
    private int no2;
    @Column(name = "no_3")
    private int no3;
    @Column(name = "no_4")
    private int no4;
    @Column(name = "no_5")
    private int no5;
    @Column(name = "no_6")
    private int no6;
    @Column(name = "bonus_no")
    private int bonusNo;
    @Column(name = "first_winner_amount")
    private long firstWinnerAmount;
    @Column(name = "first_winner_count")
    private int firstWinnerCount;
    @Column(name = "total_sell_amount")
    private long totalSellAmount;
}
