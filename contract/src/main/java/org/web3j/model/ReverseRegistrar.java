package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class ReverseRegistrar extends Contract {
    public static final String BINARY = "0x60a06040523480156200001157600080fd5b50604051620012f1380380620012f18339810160408190526200003491620001c4565b6200003f336200015b565b6001600160a01b03811660808190526040516302571be360e01b81527f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e26004820152600091906302571be390602401602060405180830381865afa158015620000ac573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190620000d29190620001c4565b90506001600160a01b038116156200015357604051630f41a04d60e11b81523360048201526001600160a01b03821690631e83409a906024016020604051808303816000875af11580156200012b573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190620001519190620001eb565b505b505062000205565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b6001600160a01b0381168114620001c157600080fd5b50565b600060208284031215620001d757600080fd5b8151620001e481620001ab565b9392505050565b600060208284031215620001fe57600080fd5b5051919050565b6080516110c26200022f6000396000818161012d0152818161033e015261058901526110c26000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c80638da5cb5b1161008c578063c66485b211610066578063c66485b214610208578063da8c229e1461021b578063e0dba60f1461024e578063f2fde38b1461026157600080fd5b80638da5cb5b146101c4578063bffbe61c146101e2578063c47f0027146101f557600080fd5b806365669631116100c85780636566963114610174578063715018a6146101875780637a806d6b14610191578063828eab0e146101a457600080fd5b80630f5a5466146100ef5780631e83409a146101155780633f15457f14610128575b600080fd5b6101026100fd366004610d75565b610274565b6040519081526020015b60405180910390f35b610102610123366004610dae565b610288565b61014f7f000000000000000000000000000000000000000000000000000000000000000081565b60405173ffffffffffffffffffffffffffffffffffffffff909116815260200161010c565b610102610182366004610dcb565b6102b7565b61018f6105f0565b005b61010261019f366004610ef0565b61067d565b60025461014f9073ffffffffffffffffffffffffffffffffffffffff1681565b60005473ffffffffffffffffffffffffffffffffffffffff1661014f565b6101026101f0366004610dae565b61071e565b610102610203366004610f65565b610779565b61018f610216366004610dae565b6107a3565b61023e610229366004610dae565b60016020526000908152604090205460ff1681565b604051901515815260200161010c565b61018f61025c366004610fb0565b610936565b61018f61026f366004610dae565b610a41565b60006102813384846102b7565b9392505050565b6002546000906102b1903390849073ffffffffffffffffffffffffffffffffffffffff166102b7565b92915050565b60008373ffffffffffffffffffffffffffffffffffffffff81163314806102ed57503360009081526001602052604090205460ff165b806103a957506040517fe985e9c500000000000000000000000000000000000000000000000000000000815273ffffffffffffffffffffffffffffffffffffffff82811660048301523360248301527f0000000000000000000000000000000000000000000000000000000000000000169063e985e9c590604401602060405180830381865afa158015610385573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103a99190610fde565b806103b857506103b881610b71565b61046f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152605b60248201527f526576657273655265676973747261723a2043616c6c6572206973206e6f742060448201527f6120636f6e74726f6c6c6572206f7220617574686f726973656420627920616460648201527f6472657373206f7220746865206164647265737320697473656c660000000000608482015260a4015b60405180910390fd5b600061047a86610c22565b604080517f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e26020808301919091528183018490528251808303840181526060909201928390528151910120919250819073ffffffffffffffffffffffffffffffffffffffff8916907f6ada868dd3058cf77a48a74489fd7963688e5464b2b0fa957ace976243270e9290600090a36040517f5ef2c7f00000000000000000000000000000000000000000000000000000000081527f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e260048201526024810183905273ffffffffffffffffffffffffffffffffffffffff87811660448301528681166064830152600060848301527f00000000000000000000000000000000000000000000000000000000000000001690635ef2c7f09060a401600060405180830381600087803b1580156105cd57600080fd5b505af11580156105e1573d6000803e3d6000fd5b50929998505050505050505050565b60005473ffffffffffffffffffffffffffffffffffffffff163314610671576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610466565b61067b6000610cde565b565b60008061068b8686866102b7565b6040517f7737221300000000000000000000000000000000000000000000000000000000815290915073ffffffffffffffffffffffffffffffffffffffff8516906377372213906106e29084908790600401610ffb565b600060405180830381600087803b1580156106fc57600080fd5b505af1158015610710573d6000803e3d6000fd5b509298975050505050505050565b60007f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e261074a83610c22565b604080516020810193909352820152606001604051602081830303815290604052805190602001209050919050565b6002546000906102b1903390819073ffffffffffffffffffffffffffffffffffffffff168561067d565b60005473ffffffffffffffffffffffffffffffffffffffff163314610824576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610466565b73ffffffffffffffffffffffffffffffffffffffff81166108c7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152603060248201527f526576657273655265676973747261723a205265736f6c76657220616464726560448201527f7373206d757374206e6f742062652030000000000000000000000000000000006064820152608401610466565b600280547fffffffffffffffffffffffff00000000000000000000000000000000000000001673ffffffffffffffffffffffffffffffffffffffff83169081179091556040517feae17a84d9eb83d8c8eb317f9e7d64857bc363fa51674d996c023f4340c577cf90600090a250565b60005473ffffffffffffffffffffffffffffffffffffffff1633146109b7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610466565b73ffffffffffffffffffffffffffffffffffffffff821660008181526001602090815260409182902080547fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff001685151590811790915591519182527f4c97694570a07277810af7e5669ffd5f6a2d6b74b6e9a274b8b870fd5114cf87910160405180910390a25050565b60005473ffffffffffffffffffffffffffffffffffffffff163314610ac2576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610466565b73ffffffffffffffffffffffffffffffffffffffff8116610b65576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201527f64647265737300000000000000000000000000000000000000000000000000006064820152608401610466565b610b6e81610cde565b50565b60008173ffffffffffffffffffffffffffffffffffffffff16638da5cb5b6040518163ffffffff1660e01b8152600401602060405180830381865afa925050508015610bf8575060408051601f3d9081017fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe0168201909252610bf59181019061106f565b60015b610c0457506000919050565b73ffffffffffffffffffffffffffffffffffffffff16331492915050565b600060285b8015610cd2577fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff017f3031323334353637383961626364656600000000000000000000000000000000600f84161a81536010909204917fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff017f3031323334353637383961626364656600000000000000000000000000000000600f84161a8153601083049250610c27565b50506028600020919050565b6000805473ffffffffffffffffffffffffffffffffffffffff8381167fffffffffffffffffffffffff0000000000000000000000000000000000000000831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b73ffffffffffffffffffffffffffffffffffffffff81168114610b6e57600080fd5b60008060408385031215610d8857600080fd5b8235610d9381610d53565b91506020830135610da381610d53565b809150509250929050565b600060208284031215610dc057600080fd5b813561028181610d53565b600080600060608486031215610de057600080fd5b8335610deb81610d53565b92506020840135610dfb81610d53565b91506040840135610e0b81610d53565b809150509250925092565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600082601f830112610e5657600080fd5b813567ffffffffffffffff80821115610e7157610e71610e16565b604051601f83017fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe0908116603f01168101908282118183101715610eb757610eb7610e16565b81604052838152866020858801011115610ed057600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060008060808587031215610f0657600080fd5b8435610f1181610d53565b93506020850135610f2181610d53565b92506040850135610f3181610d53565b9150606085013567ffffffffffffffff811115610f4d57600080fd5b610f5987828801610e45565b91505092959194509250565b600060208284031215610f7757600080fd5b813567ffffffffffffffff811115610f8e57600080fd5b610f9a84828501610e45565b949350505050565b8015158114610b6e57600080fd5b60008060408385031215610fc357600080fd5b8235610fce81610d53565b91506020830135610da381610fa2565b600060208284031215610ff057600080fd5b815161028181610fa2565b82815260006020604081840152835180604085015260005b8181101561102f57858101830151858201606001528201611013565b5060006060828601015260607fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe0601f830116850101925050509392505050565b60006020828403121561108157600080fd5b815161028181610d5356fea264697066735822122030f8ee7d282ef64d328e7804deeb2da69cb552c7cd254f7f899b8afc6a03042664736f6c63430008110033";

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_CLAIMFORADDR = "claimForAddr";

    public static final String FUNC_CLAIMWITHRESOLVER = "claimWithResolver";

    public static final String FUNC_CONTROLLERS = "controllers";

    public static final String FUNC_DEFAULTRESOLVER = "defaultResolver";

    public static final String FUNC_ENS = "ens";

    public static final String FUNC_NODE = "node";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETCONTROLLER = "setController";

    public static final String FUNC_SETDEFAULTRESOLVER = "setDefaultResolver";

    public static final String FUNC_SETNAME = "setName";

    public static final String FUNC_SETNAMEFORADDR = "setNameForAddr";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event CONTROLLERCHANGED_EVENT = new Event("ControllerChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event DEFAULTRESOLVERCHANGED_EVENT = new Event("DefaultResolverChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event REVERSECLAIMED_EVENT = new Event("ReverseClaimed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    @Deprecated
    protected ReverseRegistrar(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReverseRegistrar(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReverseRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReverseRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ControllerChangedEventResponse> getControllerChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CONTROLLERCHANGED_EVENT, transactionReceipt);
        ArrayList<ControllerChangedEventResponse> responses = new ArrayList<ControllerChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ControllerChangedEventResponse typedResponse = new ControllerChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.controller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ControllerChangedEventResponse> controllerChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ControllerChangedEventResponse>() {
            @Override
            public ControllerChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTROLLERCHANGED_EVENT, log);
                ControllerChangedEventResponse typedResponse = new ControllerChangedEventResponse();
                typedResponse.log = log;
                typedResponse.controller = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ControllerChangedEventResponse> controllerChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTROLLERCHANGED_EVENT));
        return controllerChangedEventFlowable(filter);
    }

    public static List<DefaultResolverChangedEventResponse> getDefaultResolverChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DEFAULTRESOLVERCHANGED_EVENT, transactionReceipt);
        ArrayList<DefaultResolverChangedEventResponse> responses = new ArrayList<DefaultResolverChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DefaultResolverChangedEventResponse typedResponse = new DefaultResolverChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.resolver = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DefaultResolverChangedEventResponse> defaultResolverChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DefaultResolverChangedEventResponse>() {
            @Override
            public DefaultResolverChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEFAULTRESOLVERCHANGED_EVENT, log);
                DefaultResolverChangedEventResponse typedResponse = new DefaultResolverChangedEventResponse();
                typedResponse.log = log;
                typedResponse.resolver = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DefaultResolverChangedEventResponse> defaultResolverChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEFAULTRESOLVERCHANGED_EVENT));
        return defaultResolverChangedEventFlowable(filter);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<ReverseClaimedEventResponse> getReverseClaimedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REVERSECLAIMED_EVENT, transactionReceipt);
        ArrayList<ReverseClaimedEventResponse> responses = new ArrayList<ReverseClaimedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReverseClaimedEventResponse typedResponse = new ReverseClaimedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReverseClaimedEventResponse> reverseClaimedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReverseClaimedEventResponse>() {
            @Override
            public ReverseClaimedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REVERSECLAIMED_EVENT, log);
                ReverseClaimedEventResponse typedResponse = new ReverseClaimedEventResponse();
                typedResponse.log = log;
                typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReverseClaimedEventResponse> reverseClaimedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVERSECLAIMED_EVENT));
        return reverseClaimedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> claim(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> claimForAddr(String addr, String owner, String resolver) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLAIMFORADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, resolver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> claimWithResolver(String owner, String resolver) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLAIMWITHRESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, resolver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> controllers(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTROLLERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> defaultResolver() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULTRESOLVER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ens() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ENS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> node(String addr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setController(String controller, Boolean enabled) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCONTROLLER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, controller), 
                new org.web3j.abi.datatypes.Bool(enabled)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDefaultResolver(String resolver) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETDEFAULTRESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, resolver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setName(String name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setNameForAddr(String addr, String owner, String resolver, String name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETNAMEFORADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, resolver), 
                new org.web3j.abi.datatypes.Utf8String(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ReverseRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReverseRegistrar(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReverseRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReverseRegistrar(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReverseRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReverseRegistrar(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReverseRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReverseRegistrar(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ControllerChangedEventResponse extends BaseEventResponse {
        public String controller;

        public Boolean enabled;
    }

    public static class DefaultResolverChangedEventResponse extends BaseEventResponse {
        public String resolver;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class ReverseClaimedEventResponse extends BaseEventResponse {
        public String addr;

        public byte[] node;
    }
}
