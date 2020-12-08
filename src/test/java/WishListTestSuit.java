import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import register.*;
import wishlist.*;

@RunWith(Suite.class)

@SuiteClasses({
        FTC_AddToCartButtonInWishListTest.class,
        FTC_ContinueButtonTest.class,
        FTC_DoubleAddToWishListTest.class,
        FTC_ItemLinkTest.class,
        FTC_RemoveButtoninWishListTest.class,
        FTC_SavingItemsToWishListAsLoggedInUserTest.class,
        FTC_SavingItemsToWishListAsUnregisteredUserTest.class,
        FTC_WishListPageAvailableForLoggedInUserTest.class,
        FTC_WishListPageUnavailableForUnregisteredUser.class,
})
public class WishListTestSuit {
}
