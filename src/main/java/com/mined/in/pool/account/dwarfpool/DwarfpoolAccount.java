package com.mined.in.pool.account.dwarfpool;

import static java.math.BigDecimal.ROUND_HALF_UP;

import java.math.BigDecimal;

import org.json.JSONObject;

import com.mined.in.pool.account.Account;

/**
 * Class for representing Dwarfpool account.
 *
 * @author Dmitry Tverdokhleb
 *
 */
public class DwarfpoolAccount extends Account {

    /**
     * Creates the Dwarfpool account instance.
     *
     * @param walletAddress wallet address
     * @param walletBalance wallet balance
     */
    private DwarfpoolAccount(String walletAddress, BigDecimal walletBalance) {
        super(walletAddress, walletBalance);
    }

    /**
     * Creates the Dwarfpool account instance from JSON format.
     *
     * @param walletAddress wallet address
     * @param jsonAccount account in JSON format
     * @return Dwarfpool account instance
     */
    public static DwarfpoolAccount create(String walletAddress, JSONObject jsonAccount) {
        BigDecimal walletBalance = new BigDecimal(jsonAccount.getDouble("wallet_balance"));
        walletBalance = walletBalance.setScale(8, ROUND_HALF_UP);
        return new DwarfpoolAccount(walletAddress, walletBalance);
    }

}
