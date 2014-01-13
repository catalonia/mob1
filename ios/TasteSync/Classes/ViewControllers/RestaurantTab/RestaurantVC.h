//
//  RestaurantVC.h
//  TasteSync
//
//  Created by Victor on 2/19/13.
//  Copyright (c) 2013 Mobioneer. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "RateCustom.h"
#import "CRequest.h"
#import "JSONKit.h"

@interface RestaurantVC : UIViewController<UITableViewDataSource, UITableViewDelegate,RateCustomDelegate, UIScrollViewDelegate, RequestDelegate,UITextFieldDelegate>
{
    __weak IBOutlet UITableView *tbvResult, *tbvFilter;
    __weak IBOutlet UITextField *tfRestaurant, *tfRegion;
    __weak IBOutlet UIView *viewFilter1, *viewFilter2, *viewFilterExtends, *viewFilterSmall, *viewMain;
    __weak IBOutlet UILabel *lbTypingRestaurant, *lbTypeRegions;
    __weak IBOutlet UIScrollView *scrollViewMain;
    
    __weak IBOutlet UIScrollView *scrollViewCuisine, *scrollViewPrice;
    __weak IBOutlet UIButton *btSaved, *btFavs, *btDeals, *btShow, *btHide;
    __weak IBOutlet UILabel *lbSaved, *lbFaved;
    
    int _rating;
    BOOL saved, favs , deals, restaurantChains;
    
    NSMutableDictionary *filterDict;
    
    __weak IBOutlet UILabel *lbCusine, *lbPrice, *lbRating, *lbShowOnlyThese;
    
    
    NSMutableArray *arrDataAsk;
    NSMutableArray *arrayCuisine;
    NSMutableArray *arrayAmbience;
    NSMutableArray *arrayWhoWithYou;
    NSMutableArray *arrayPrice;
    NSMutableArray *arrayCity;
    
    IBOutlet UIView* _elementView;
    IBOutlet UIView* _cuisineView;
    IBOutlet UITableView* _tableViewPrice;
    IBOutlet UITableView* _tableViewCuisine;
    __weak IBOutlet UIImageView* _cuisineImage;
    IBOutlet UITextField* _textFieldSearch;
}

@property (nonatomic, strong) NSMutableArray *arrData, *arrDataFilter , *arrDataRestaurant , *arrDataRegion;
@property (nonatomic,strong) NSString* recorequestID;

@property (nonatomic, assign) BOOL notHomeScreen;
@property (nonatomic, assign) int rating;

- (IBAction)actionOthersTab:(id)sender;
- (IBAction)actionNewsfeed:(id)sender;
- (IBAction)actionHideKeypad:(id)sender;

- (IBAction)actionFilter:(id)sender;
- (IBAction)actionDoneFilter:(id)sender;
- (IBAction)actionSaved:(id)sender;
- (IBAction)actionFavs:(id)sender;
- (IBAction)actionDeals:(id)sender;
- (IBAction)actionShow:(id)sender;
- (IBAction)actionHide:(id)sender;

@end
