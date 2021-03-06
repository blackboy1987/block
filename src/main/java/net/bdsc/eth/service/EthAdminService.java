package net.bdsc.eth.service;

import net.bdsc.entity.Member;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.core.methods.response.EthAccounts;

import java.io.IOException;
import java.math.BigDecimal;

public interface EthAdminService {

    PersonalListAccounts personalListAccounts() throws IOException;

    NewAccountIdentifier newAccountIdentifier(String password);

    EthAccounts ethAccounts() throws IOException;

    String ethGetBalance(String address);

    String transferEther(Member from, Member to, BigDecimal amount);
}
