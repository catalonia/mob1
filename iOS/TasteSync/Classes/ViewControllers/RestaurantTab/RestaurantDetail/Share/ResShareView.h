//
//  ResShareView.h
//  TasteSync
//
//  Created by Victor on 1/5/13.
//  Copyright (c) 2013 Mobioneer. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "RestaurantObj.h"
#import <Twitter/Twitter.h>


@protocol ResShareViewDelegate <NSObject>

@optional

- (BOOL) resShareViewDidShareViaMessage;
- (BOOL) resShareViewDidShareViaMail;
- (BOOL) resShareViewDidShareViaFacebook;
- (BOOL) resShareViewDidShareViaDirections;
- (BOOL) resShareViewDidShareViaCall;
- (BOOL) resShareViewDidShareViaTwitter;
- (BOOL) resShareViewDidCancel;

@end

@interface ResShareView : UIView
{
    
}

- (IBAction)actionShareViaMessage:(id)sender;
- (IBAction)actionShareViaMail:(id)sender;
- (IBAction)actionShareViaFacebook:(id)sender;
- (IBAction)actionShareViaDirections:(id)sender;
- (IBAction)actionShareViaCall:(id)sender;
- (IBAction)actionShareViaTwitter:(id)sender;
- (IBAction)actionCancel:(id)sender;

@property (nonatomic, strong) id<ResShareViewDelegate> delegate;
@property (nonatomic, strong) RestaurantObj *restaurantObj;
@property (nonatomic, strong ) TWTweetComposeViewController *twtcontroller ;

- (void) shareRestaurant:(RestaurantObj *) resObj andDelegate:(id<ResShareViewDelegate>) i_delegate Title:(NSString*)title Subtitle:(NSString*)subtitle Content:(NSString*)content;
-(void)shareToFacebookRestaurant:(RestaurantObj *) resObj andDelegate:(id<ResShareViewDelegate>) i_delegate Title:(NSString*)title Subtitle:(NSString*)subtitle Content:(NSString*)content;

@end
