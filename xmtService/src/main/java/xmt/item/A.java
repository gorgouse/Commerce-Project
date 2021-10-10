//package xmt.item;
//
//import xmt.item.webapp.dao.AddressDao;
//import xmt.item.webapp.dao.AreaDao;
//import xmt.item.webapp.entity.AddressInfo;
//import xmt.item.webapp.entity.AreaInfo;
//
//import java.util.List;
//
//public class A {
//    public static void main(String[] args) {
//        A.B b = new A.B();
//        System.out.println(b.isFirst());
//    }
//
//    static class B implements AddressDao, AreaDao {
//        @Override
//        public Integer isFirst(String userId) {
//            return null;
//        }
//
//        @Override
//        public int addAddress(AddressInfo addressInfo) {
//            return 0;
//        }
//
//        @Override
//        public List<AddressInfo> addressList(AddressInfo addressInfo) {
//            return null;
//        }
//
//        @Override
//        public int updateAddress(AddressInfo addressInfo) {
//            return 0;
//        }
//
//        @Override
//        public int selectDefaultAsFault(String userId) {
//            return 0;
//        }
//
//        @Override
//        public AddressInfo selectDefault(String userId) {
//            return null;
//        }
//
//        @Override
//        public AddressInfo selectAddressById(String id) {
//            return null;
//        }
//
//        @Override
//        public List<AreaInfo> getProvinceList() {
//            return null;
//        }
//
//        @Override
//        public List<AreaInfo> getCityList() {
//            return null;
//        }
//
//        @Override
//        public List<AreaInfo> getAreaList() {
//            return null;
//        }
//
//        @Override
//        public List<AreaInfo> getSubDomain(AreaInfo areaInfo) {
//            return null;
//        }
//
//        @Override
//        public String getId(String name) {
//            return null;
//        }
//    }
//}
