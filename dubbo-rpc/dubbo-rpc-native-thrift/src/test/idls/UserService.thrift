namespace java org.apache.dubbo.rpc.protocol.nativethrift
namespace go demo

com.atlwj.service UserService {
    string find(1:required i32 id);
}