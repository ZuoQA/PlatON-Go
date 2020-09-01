package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.WasmEventEncoder;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmEvent;
import org.web3j.abi.datatypes.WasmEventParameter;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.PlatonFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.1.1.
 */
public class Platon_gas_price extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001520f60017f0060027f7f0060017f017f60000060027f7f017f60037f7f7f017f60037f7f7f0060047f7f7f7f0060047f7f7f7f017f60027f7e0060037e7e7f006000017f60027e7e017f6000017e60017f017e02ff010c03656e760c706c61746f6e5f70616e6963000303656e760b706c61746f6e5f73686133000703656e760a706c61746f6e5f676173000d03656e760d726c705f6c6973745f73697a65000203656e760f706c61746f6e5f726c705f6c697374000603656e760e726c705f62797465735f73697a65000403656e7610706c61746f6e5f726c705f6279746573000603656e760d726c705f753132385f73697a65000c03656e760f706c61746f6e5f726c705f75313238000a03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000b03656e7610706c61746f6e5f6765745f696e707574000003656e760c706c61746f6e5f6576656e740007032b2a0309040204020200010504010100000006010101050201050800050602050308010400020e01030302020405017001030305030100020608017f0141c088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000c0f5f5f66756e63735f6f6e5f65786974003206696e766f6b65002a0908010041010b021a1b0a9f402a040010330bb40802087f017e23004190016b22032400200341086a418b08100e2104200341306a100f1a200341c4006a41003602002003420037023c200341306a4101101021070240200428020420032d00082205410176200541017122081b2205450d002004280208200441016a20081b2104200510112206210203402005450d01200220042d00003a00002005417f6a2105200241016a2102200441016a21040c000b000b200220066b41204b0440412010112104410021050340200420056a41003a0000200541016a22054120470d000b2006200220066b200420051001200420056a2102200421060b200341f8006a4100360200200341f0006a4200370300200341e8006a420037030020034200370360024020022006460440410121050c010b4101210502400240200220066b2204410146044020062c0000417f4c0d010c030b200441374b0d010b200441016a21050c010b2004101220046a41016a21050b20032005360260200341e0006a410472101320072005101420072006200220066b10152102200328023c200328024047044010000b2002280204210620022802002107200341186a100f21082003412c6a410036020020034200370224200341c8006a20001016210520032001370358200341f8006a4100360200200341f0006a4200370300200341e8006a420037030020034200370360200341e0006a410010174101210402400240024020034180016a20051016220028020420032d0080012202410176200241017122091b220241014d0440200241016b0d032000280208200041016a20091b2c0000417f4c0d010c030b200241374b0d010b200241016a21040c010b2002101220026a41016a21040b027f200341e0006a20032802782202450d001a2003280268200220032802746a417f6a220241087641fcffff07716a280200200241ff07714102746a0b2202200228020020046a360200410121042003290358220a4280015a0440420021014100210203402001200a84504504402001423886200a42088884210a200241016a2102200142088821010c010b0b200241384f047f2002101220026a0520020b41016a21040b027f200341e0006a20032802782202450d001a2003280268200220032802746a417f6a220241087641fcffff07716a280200200241ff07714102746a0b2202200228020020046a360200200341e0006a4101101720032802602102200341e0006a4104721013200341186a20021014200341186a41021010200341e0006a200510162202280208200241016a20032d0060220541017122041b2002280204200541017620041b1015210220084200200329035822011007200228020422056a101842002001200520022802006a1008200210192003280224200328022847044010000b2007200620022802002002280204100b200328022422020440200320023602280b200328023c22020440200320023602400b20034190016a24000b910101027f20004200370200200041086a410036020020012102024003402002410371044020022d0000450d02200241016a21020c010b0b2002417c6a21020340200241046a22022802002203417f73200341fffdfb776a7141808182847871450d000b0340200341ff0171450d01200241016a2d00002103200241016a21020c000b000b20002001200220016b101c20000b1800200041003602082000420037020020004100101d20000bf30101057f20002802042105200041106a2802002202200041146a280200220349044020022001ad2005ad422086843702002000200028021041086a36021020000f0b027f41002002200028020c22046b410375220641016a2202200320046b2203410275220420042002491b41ffffffff01200341037541ffffffff00491b2204450d001a200441037410110b2102200220064103746a22032001ad2005ad4220868437020020032000280210200028020c22066b22016b2105200220044103746a2102200341086a2103200141014e044020052006200110291a0b20002002360214200020033602102000200536020c20000b0b002000410120001b10280b1e01017f03402000044020004108762100200141016a21010c010b0b20010bea0101047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a2000101e200428020c210203400240200120024604402000410036021420002802082103200028020421010340200320016b41027522024103490d022000200141046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b20002001101f200441106a24000b13002000280208200149044020002001101d0b0b2a01017f2000200120021005200028020422036a101820012002200320002802006a10062000101920000b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204101c20000bc10c02077f027e230041306b22042400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022031020280200210120022003417f6a360200200710214180104f044020072000410c6a280200417c6a101f0b200141384f047f2001101220016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002102021000c010b0240200710210d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021032001200241046a360200200420033602182007200441186a10220c010b2000410c6a2802002202200041086a2802006b4102752203200041106a2205280200220620002802046b220141027549044041802010112105200220064704400240200028020c220120002802102202470d0020002802082203200028020422064b04402000200320012003200320066b41027541016a417e6d41027422026a1023220136020c2000200028020820026a3602080c010b200441186a200220066b2201410175410120011b22012001410276200041106a10242102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021025200028020c21010b200120053602002000200028020c41046a36020c0c020b02402000280208220120002802042202470d00200028020c2203200028021022064904402000200120032003200620036b41027541016a41026d41027422026a102622013602082000200028020c20026a36020c0c010b200441186a200620026b2201410175410120011b2201200141036a410276200041106a10242102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021025200028020821010b2001417c6a2005360200200020002802082201417c6a22023602082002280200210220002001360208200420023602182007200441186a10220c010b20042001410175410120011b200320051024210241802010112106024020022802082201200228020c2203470d0020022802042205200228020022084b04402002200520012005200520086b41027541016a417e6d41027422036a102322013602082002200228020420036a3602040c010b200441186a200320086b2201410175410120011b22012001410276200241106a280200102421032002280208210520022802042101034020012005470440200328020820012802003602002003200328020841046a360208200141046a21010c010b0b20022902002109200220032902003702002003200937020020022902082109200220032902083702082003200937020820031025200228020821010b200120063602002002200228020841046a360208200028020c2105034020002802082005460440200028020421012000200228020036020420022001360200200228020421012002200536020420002001360208200029020c21092000200229020837020c2002200937020820021025052005417c6a210502402002280204220120022802002203470d0020022802082206200228020c22084904402002200120062006200820066b41027541016a41026d41027422036a102622013602042002200228020820036a3602080c010b200441186a200820036b2201410175410120011b2201200141036a4102762002280210102421062002280208210320022802042101034020012003470440200428022020012802003602002004200428022041046a360220200141046a21010c010b0b20022902002109200220042903183702002002290208210a20022004290320370208200420093703182004200a37032020061025200228020421010b2001417c6a200528020036020020022002280204417c6a3602040c010b0b0b200441186a2007101e200428021c4100360200200041186a2100410121010b2000200028020020016a360200200441306a24000b3601017f2000280208200149044020011028200028020020002802041029210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210036a1018200120002802006a22012002200110040c010b0b0b0300010b3001027e230041206b220024001002210110021a10022102200041106a418008100e200120027d100d200041206a24000b6101027f027f02402002410b4f0440200241106a4170712204101121032000200236020420002004410172360200200020033602080c010b200020024101743a0000200041016a22032002450d011a0b20032001200210290b20026a41003a00000b2f01017f2000280208200149044020011028200028020020002802041029210220002001360208200020023602000b0b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b25002000200120026a417f6a220241087641fcffff07716a280200200241ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2203470d0020002802042204200028020022064b04402000200420022004200420066b41027541016a417e6d41027422036a102322023602082000200028020420036a3602040c010b200541086a200320066b2202410175410120021b220220024102762000410c6a10242103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b20002902002107200020032902003702002003200737020020002902082107200020032902083702082003200737020820031025200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110270b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274101121040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110270b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210291a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b9b0101047f230041106b220124002001200036020c2000047f41b408200041086a2202411076220041b4082802006a220336020041b00841b008280200220420026a41076a417871220236020002400240200341107420024d044041b408200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104102941086a0541000b2100200141106a240020000bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000ba50502087f017e230041406a2205240010331009220010282201100a0240200541206a20012000411c102b2204280208450440200441146a2802002100200428021021010c010b200541386a2004102c20042005280238200528023c102d36020c200541086a2004102c410021002004027f410020052802082202450d001a4100200528020c2206200428020c2203490d001a200620032003417f461b210020020b2201360210200441146a2000360200200441003602080b200541086a200120004114102b2200102e024002402000280204450d002000102e0240200028020022022c0000220141004e044020010d010c020b200141807f460d00200141ff0171220341b7014d0440200028020441014d04401000200028020021020b20022d00010d010c020b200341bf014b0d012000280204200141ff017141ca7e6a22014d04401000200028020021020b200120026a2d0000450d010b2000280204450d0020022d000041c001490d010b10000b2000102f2206200028020422024b04401000200028020421020b20002802002107024002400240200204404100210320072c00002200417f4a0d01027f200041ff0171220341bf014d04404100200041ff017141b801490d011a200341c97e6a0c010b4100200041ff017141f801490d001a200341897e6a0b41016a21030c010b4101210320070d00410021000c010b41002100200320066a20024b0d0020022006490d004100210120022003490d01200320076a2101200220036b20062006417f461b22004109490d0110000c010b410021010b0340200004402000417f6a210020013100002008420886842108200141016a21010c010b0b024002402008500d00419308103020085104402004410110310c020b41980810302008520d002004410210310c010b10000b1032200541406b24000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000103420024f0d002003410471044010000c010b200042003702000b02402003411071450d002000103420024d0d0020034104710440100020000f0b200042003702000b20000b7201047f2001102f220220012802044b044010000b2001103521032000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012003490d00410020012002490d011a200320056a2104200120036b20022002417f461b0c010b41000b360204200020043602000b2701017f230041206b22022400200241086a200020014114102b10342100200241206a240020000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000102e41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b920101047f230041106b22022400024002402000280204450d0020002802002d000041c001490d00200241086a2000102c41012104200228020c2100034020000440200241002002280208220320032000102d22056a20034520002005497222031b3602084100200020056b20031b21002004417f6a21040c010b0b2004450d010b10000b20022001110000200241106a24000b880101037f41a008410136020041a4082802002100034020000440034041a80841a8082802002201417f6a2202360200200141014845044041a0084100360200200020024102746a22004184016a280200200041046a28020011000041a008410136020041a40828020021000c010b0b41a808412036020041a408200028020022003602000c010b0b0b3501017f230041106b220041c0880436020c41ac08200028020c41076a417871220036020041b008200036020041b4083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010352000102f6a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b0b2301004180080b1c706c61746f6e5f676173004761735573656400696e69740074657374";

    public static String BINARY = BINARY_0;

    public static final String FUNC_TEST = "test";

    public static final WasmEvent GASUSED_EVENT = new WasmEvent("GasUsed", Arrays.asList(), Arrays.asList(new WasmEventParameter(String.class) , new WasmEventParameter(Uint64.class)));
    ;

    protected Platon_gas_price(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected Platon_gas_price(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public List<GasUsedEventResponse> getGasUsedEvents(TransactionReceipt transactionReceipt) {
        List<WasmContract.WasmEventValuesWithLog> valueList = extractEventParametersWithLog(GASUSED_EVENT, transactionReceipt);
        ArrayList<GasUsedEventResponse> responses = new ArrayList<GasUsedEventResponse>(valueList.size());
        for (WasmContract.WasmEventValuesWithLog eventValues : valueList) {
            GasUsedEventResponse typedResponse = new GasUsedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
            typedResponse.arg2 = (Uint64) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<GasUsedEventResponse> gasUsedEventObservable(PlatonFilter filter) {
        return web3j.platonLogObservable(filter).map(new Func1<Log, GasUsedEventResponse>() {
            @Override
            public GasUsedEventResponse call(Log log) {
                WasmContract.WasmEventValuesWithLog eventValues = extractEventParametersWithLog(GASUSED_EVENT, log);
                GasUsedEventResponse typedResponse = new GasUsedEventResponse();
                typedResponse.log = log;
                typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
                typedResponse.arg2 = (Uint64) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<GasUsedEventResponse> gasUsedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        PlatonFilter filter = new PlatonFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(WasmEventEncoder.encode(GASUSED_EVENT));
        return gasUsedEventObservable(filter);
    }

    public static RemoteCall<Platon_gas_price> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Platon_gas_price.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Platon_gas_price> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Platon_gas_price.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Platon_gas_price> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Platon_gas_price.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<Platon_gas_price> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Platon_gas_price.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> test() {
        final WasmFunction function = new WasmFunction(FUNC_TEST, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> test(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_TEST, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static Platon_gas_price load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new Platon_gas_price(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static Platon_gas_price load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new Platon_gas_price(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static class GasUsedEventResponse {
        public Log log;

        public String arg1;

        public Uint64 arg2;
    }
}
