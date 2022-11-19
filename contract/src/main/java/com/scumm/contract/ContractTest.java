package com.scumm.contract;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.ens.NameHash;
import org.web3j.model.ENSRegistry;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

//1.Hash.sha3String() 等同于  const sha3 = require('web3-utils').sha3
//2.NameHash.nameHash("aaaaaa.sns")  等同于 const namehash = require('eth-ens-namehash').hash
//3.Numeric.toBigInt()  可以把hash转成 BigInt
public class ContractTest {

    public static void main(String[] args) {
        Web3j web3j = Web3j.build(new HttpService("https://goerli.infura.io/v3/49fb3b593a324bffa7bcd9653f73f7c3"));
        Credentials credentials = Credentials.create("ee75d10255e3dda1a26f7275d1c9218e21c1f50f54a71f5546eaa2a95c9b8440");
        ENSRegistry ensRegistry = ENSRegistry.load(
                "0x6Cb0a4Dd7e074B967f42B8d1cD43BC72B7C04b88",
                web3j,
                credentials,
                new StaticGasProvider(BigInteger.valueOf(4000000000L),BigInteger.valueOf(300000)));

        //Hash
        System.out.println(NameHash.nameHash("aaaaaa.sns"));
        System.out.println(Numeric.toBigInt(NameHash.nameHashAsBytes("aaaaaa.sns")));
        //NameHash.nameHash("aaaaaa.sns") = 0xaea9b540c80b53001a47da5d9f40d0035870b4cee711702942c2632bccd6f69c
//        Uint256 u256 = new Uint256();


//        ensRegistry.owner(Number);
        Boolean r = available(web3j, "0x8228b958a87adc7EC818b6f9ffd0552c3d4da735");
        System.out.println(r);

        String owner = ownerOf(web3j, "0x3728bEbaec9C3Af02b8fC931C43e786DCCf50091");
        System.out.println(owner);


    }

    public static Boolean available(Web3j web3j, String contractAddress) {
        if (web3j == null) return null;
        String methodName = "available";
        Boolean totalSupply = false;
        List<Type> inputParameters = Arrays.asList(new Utf8String("bbbbbb"));
        List<TypeReference<?>> outputParameters = Arrays.asList(new TypeReference<Bool>() {});


        Function function = new Function(methodName, inputParameters, outputParameters);

        String data = FunctionEncoder.encode(function);
        Transaction transaction = Transaction.createEthCallTransaction("0xBE60f9Bfe340885511c0dED5f994677d55c8F5fD", contractAddress, data);

        EthCall ethCall;
        try {
            ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).sendAsync().get();
            List<Type> results = FunctionReturnDecoder.decode(ethCall.getValue(), function.getOutputParameters());
            totalSupply = (Boolean) results.get(0).getValue();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return totalSupply;
    }

    public static String ownerOf(Web3j web3j, String contractAddress) {
        if (web3j == null) return null;
        String methodName = "ownerOf";
        String totalSupply = "";

        //NameHash.nameHash("aaaaaa.sns") = 0xaea9b540c80b53001a47da5d9f40d0035870b4cee711702942c2632bccd6f69c
        List<Type> inputParameters = Arrays.asList(new Uint256(Numeric.toBigInt(NameHash.nameHash("aaaaaa.sns"))));
        List<TypeReference<?>> outputParameters = Arrays.asList(new TypeReference<Address>() {});


        Function function = new Function(methodName, inputParameters, outputParameters);

        String data = FunctionEncoder.encode(function);
        Transaction transaction = Transaction.createEthCallTransaction("0xBE60f9Bfe340885511c0dED5f994677d55c8F5fD", contractAddress, data);

        EthCall ethCall;
        try {
            ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).sendAsync().get();
            List<Type> results = FunctionReturnDecoder.decode(ethCall.getValue(), function.getOutputParameters());
            totalSupply = (String) results.get(0).getValue();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return totalSupply;
    }

}
