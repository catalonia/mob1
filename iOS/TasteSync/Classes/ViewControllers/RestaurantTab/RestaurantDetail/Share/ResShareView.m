//
//  ResShareView.m
//  TasteSync
//
//  Created by Victor on 1/5/13.
//  Copyright (c) 2013 Mobioneer. All rights reserved.
//

#import "ResShareView.h"
#import "CommonHelpers.h"
#import "ResShareFB.h"
#import <MessageUI/MessageUI.h>
#import <MapKit/MapKit.h>
#import <CoreLocation/CoreLocation.h>
#import <AddressBook/AddressBook.h>

@interface ResShareView()<UIAlertViewDelegate,MFMailComposeViewControllerDelegate,MFMessageComposeViewControllerDelegate>
{
    MFMailComposeViewController *mailer;
    NSString* _title;
    NSString* _subtitle;
    NSString* _content;
    
    
}

@end

@implementation ResShareView

@synthesize restaurantObj=_restaurantObj,
twtcontroller=_twtcontroller,
delegate=_delegate;


- (id)initWithFrame:(CGRect)frame
{
    frame = CGRectMake(0, 600, 320, 480);
    self = [super initWithFrame:frame];
    if (self) {
            self = [[[NSBundle mainBundle ] loadNibNamed:@"ResShareView" owner:self options:nil] objectAtIndex:0];
        [self setFrame:frame];
    }
    return self;
}



- (void) shareRestaurant:(RestaurantObj *) resObj andDelegate:(id<ResShareViewDelegate>) i_delegate Title:(NSString*)title Subtitle:(NSString*)subtitle Content:(NSString*)content

{
    self.delegate = i_delegate;
    self.restaurantObj = resObj;
    _title = title;
    _subtitle = subtitle;
    _content = content;
    
    [[[UIApplication sharedApplication] keyWindow] addSubview:self];    
   
    [UIView animateWithDuration:0.4
                          delay:0
                        options: UIViewAnimationCurveEaseOut
                     animations:^{
                         if (IS_IPHONE_5) {
                             self.frame = CGRectMake(0,0, 320,568);
                         }
                         else
                         {
                             self.frame = CGRectMake(0,0, 320, 480);

                         }
                     }
                     completion:^(BOOL finished){                         
                         
                         debug(@"Show Done! in frame ");
                         
                         
                     }];

}
-(void)shareToFacebookRestaurant:(RestaurantObj *) resObj andDelegate:(id<ResShareViewDelegate>) i_delegate Title:(NSString*)title Subtitle:(NSString*)subtitle Content:(NSString*)content
{
    self.delegate = i_delegate;
    self.restaurantObj = resObj;
    _title = title;
    _subtitle = subtitle;
    _content = content;
    [self shareFacebook];
}
# pragma mark - IBAction's define

- (IBAction)actionShareViaMessage:(id)sender
{
//    [self.delegate resShareViewDidShareViaMessage];
    if ([MFMessageComposeViewController canSendText]) {
        debug(@"Can send text");
        MFMessageComposeViewController *controller = [[MFMessageComposeViewController alloc] init];
        controller.messageComposeDelegate = self;
        controller.body = [NSString stringWithFormat:@"Check out this restaurant I found on TasteSync: \n %@ \n %@ \n Get the TasteSync app at www.tastesync.com to...", _restaurantObj.name, _restaurantObj.address];
        self.hidden = YES;

        [[[[UIApplication sharedApplication] keyWindow] rootViewController] presentViewController:controller animated:NO completion:nil];

        
    }else
    {
         [CommonHelpers showInfoAlertWithTitle:APP_NAME message:@"Your devide doesn't support this function." delegate:nil tag:1];
    }
}
- (IBAction)actionShareViaMail:(id)sender
{
    if ([MFMailComposeViewController canSendMail]) {
        mailer = [[MFMailComposeViewController alloc] init];
        mailer.mailComposeDelegate = self;
        [mailer setSubject:@"TasteSync"];
        NSString *body = [NSString stringWithFormat:@"Check out this restaurant I found on TasteSync: \n %@ \n %@ \n Get the TasteSync app at www.tastesync.com to...", _restaurantObj.name, _restaurantObj.address];
        [mailer setMessageBody:body isHTML:NO];
        self.hidden = YES;
        [[[[UIApplication sharedApplication] keyWindow] rootViewController] presentViewController:mailer animated:NO completion:nil];
        
        
        
    }
    else
    {
        [CommonHelpers showInfoAlertWithTitle:APP_NAME message:@"Your devide doesn't support this function." delegate:nil tag:1];
    }
    
}
- (IBAction)shareFacebook
{
    //ResShareFB *shareFbView = [[ResShareFB alloc] initWithFrame:CGRectZero];
    //if ([[[FBSession activeSession]permissions]indexOfObject:@"publish_actions"] == NSNotFound) {
    if (![self.delegate resShareViewDidShareViaFacebook]) {
        [CommonHelpers showInfoAlertWithTitle:@"TasteSync" message:@"Tastesync needs your permission to share on Facebook" delegate:nil tag:0];
        
    }else
    {
        
        NSDictionary* params = @{@"name": _title,
                                 @"caption": _subtitle,
                                 @"description": _content,
                                 @"link": @"http://www.apple.com/osx/apps/app-store.html",
                                 @"picture": @"http://pbs.twimg.com/profile_images/3383334096/83e1ce2766040c82958c5f465ee07c48_reasonably_small.png"};
        
        if (FBSession.activeSession.isOpen)
        {
            [FBRequestConnection startWithGraphPath:@"/me/feed"
                                         parameters:params
                                         HTTPMethod:@"POST"
                                  completionHandler:^(FBRequestConnection *connection, id result, NSError *error) {
                                      if (!error) {
                                          // Link posted successfully to Facebook
                                          NSLog(@"Success");
                                      } else {
                                          // An error occurred, we need to handle the error
                                          // See: https://developers.facebook.com/docs/ios/errors
                                          NSLog(@"Error");
                                      }
                                  }];
        } else {
            
            [FBSession.activeSession
             requestNewPublishPermissions:[NSArray arrayWithObject:@"publish_actions"]
             defaultAudience:FBSessionDefaultAudienceEveryone
             completionHandler:^(FBSession *session, NSError *error) {
                 if (error) {
                 } else {
                     [FBRequestConnection startWithGraphPath:@"/me/feed"
                                                  parameters:params
                                                  HTTPMethod:@"POST"
                                           completionHandler:^(FBRequestConnection *connection, id result, NSError *error) {
                                               if (!error) {
                                                   // Link posted successfully to Facebook
                                                   NSLog(@"Success");
                                               } else {
                                                   // An error occurred, we need to handle the error
                                                   // See: https://developers.facebook.com/docs/ios/errors
                                                   NSLog(@"Error");
                                               }
                                           }];
                 }
             }];
        }
        
        
    }
}
- (IBAction)actionShareViaFacebook:(id)sender
{
    //ResShareFB *shareFbView = [[ResShareFB alloc] initWithFrame:CGRectZero];
    //if ([[[FBSession activeSession]permissions]indexOfObject:@"publish_actions"] == NSNotFound) {
    if (![self.delegate resShareViewDidShareViaFacebook]) {
        [CommonHelpers showInfoAlertWithTitle:@"TasteSync" message:@"Tastesync needs your permission to share on Facebook" delegate:nil tag:0];
        
    }else
    {
        //[NSArray arrayWithObjects:@"publish_stream", nil]
        [FBSession openActiveSessionWithPublishPermissions:nil defaultAudience:FBSessionDefaultAudienceEveryone allowLoginUI:YES completionHandler:^(FBSession *session,
                                                                                                                                                       FBSessionState state, NSError *error) {
            if (FBSession.activeSession.isOpen && !error) {
                id<FBOpenGraphAction> action = (id<FBOpenGraphAction>)[FBGraphObject graphObject];
                [action setObject:@"http://www.apple.com/osx/apps/app-store.html"forKey:@"book"];
                
                
                
                FBOpenGraphActionShareDialogParams* params = [[FBOpenGraphActionShareDialogParams alloc]init];
                params.actionType = @"books.reads";
                params.action = action;
                params.previewPropertyName = @"book";
                
                
                
                // Show the Share dialog if available
                if([FBDialogs canPresentShareDialogWithOpenGraphActionParams:params]) {
                    
                    [FBDialogs presentShareDialogWithOpenGraphAction:[params action]
                                                          actionType:[params actionType]
                                                 previewPropertyName:[params previewPropertyName]
                                                             handler:^(FBAppCall *call, NSDictionary *results, NSError *error) {
                                                                 // handle response or error
                                                             }];
                    
                }
                // If the Facebook app isn't available, show the Feed dialog as a fallback
                else {
                    NSDictionary* params = @{@"name": _title,
                                             @"caption": _subtitle,
                                             @"description": _content,
                                             @"link": @"http://www.apple.com/osx/apps/app-store.html",
                                             @"picture": @"http://pbs.twimg.com/profile_images/3383334096/83e1ce2766040c82958c5f465ee07c48_reasonably_small.png"};
                    
                    [FBWebDialogs presentFeedDialogModallyWithSession:nil
                                                           parameters:params
                                                              handler:^(FBWebDialogResult result, NSURL *resultURL, NSError *error) {
                                                                  // handle response or error
                                                              }];
                }
            }}];
        
        
    }
}
- (IBAction)actionShareViaDirections:(id)sender
{
    [CommonHelpers showConfirmAlertWithTitle:APP_NAME message:@"Do you want to open Maps app on your device?" delegate:self tag:2];
}
- (IBAction)actionShareViaCall:(id)sender
{

    [CommonHelpers showConfirmAlertWithTitle:APP_NAME message:@"Do you want to call this restaurant?" delegate:self tag:1];
    
}
- (IBAction)actionShareViaTwitter:(id)sender
{
     [self.delegate resShareViewDidShareViaTwitter];
    if (_restaurantObj) {
        NSString *msg = [NSString stringWithFormat:@"Check out this restaurant. I found on TasteSync: %@, get the TastSync app at %@ to...",TASTESYNC_URL,_restaurantObj.name];
        [self shareTwitter:msg image:nil linkUrl:nil];
    }
    else
    {
        [self shareTwitter:@"Check out this restaurant. I found on TasteSync: Nanking, get the TastSync app at www.tastsync.com to..." image:nil linkUrl:nil];

    }
}

- (IBAction)actionCancel:(id)sender
{
    [UIView animateWithDuration:0.4
                          delay:0
                        options: UIViewAnimationCurveEaseOut
                     animations:^{
                         self.frame = CGRectMake(0, 600, 320, self.frame.size.height);
                     }
                     completion:^(BOOL finished){
                         
                         debug(@"Hide Done! in frame ");
                         
                         
                     }];

}

- (void) touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
//    [UIView animateWithDuration:0.4
//                          delay:0
//                        options: UIViewAnimationCurveEaseOut
//                     animations:^{
//                         self.frame = CGRectMake(0, 600, 320, self.frame.size.height);
//                     }
//                     completion:^(BOOL finished){
//                         
//                         debug(@"Hide Done! in frame ");
//                         
//                         
//                     }];
//
}

#pragma mark - share Twitter

- (void) shareTwitter :(NSString *)txtMsg image:(UIImage *)image linkUrl:(NSString *) link

{
    UIViewController *viewCtr= [[[UIApplication sharedApplication] keyWindow] rootViewController];
    _twtcontroller = [[TWTweetComposeViewController alloc] init];
    _twtcontroller.completionHandler = ^(TWTweetComposeViewControllerResult result){
        
        [viewCtr dismissViewControllerAnimated:YES completion:nil];
        
        switch (result) {
            case TWTweetComposeViewControllerResultCancelled:
                //                [CommonHelper showAlertWithTitle:@"ERROR" message:@"Can't post on twitter'" delegate:nil cancelButtonTitle:TXT_OK otherButtonTitles:nil];
                break;
            case TWTweetComposeViewControllerResultDone:
                //[CommonHelper showErrorMessage:@"Posted your tweet"];
                break;
            default:
                break;
        }
    };
    
    //NSLog(@"ShareTW - > txtMsg -> %@",txtMsg);
    
    [_twtcontroller setInitialText:txtMsg];
    [_twtcontroller addImage:image];
    [_twtcontroller addURL:[NSURL URLWithString:link]];
    [viewCtr presentViewController:_twtcontroller animated:YES completion:nil];
    
}

- (void) mailComposeController:(MFMailComposeViewController *)controller didFinishWithResult:(MFMailComposeResult)result error:(NSError *)error
{
    switch (result) {
        case MFMailComposeResultCancelled:
            debug(@"Cancel");
            break;
            case MFMailComposeResultSaved:
            debug(@"Saved");
            break;
            case MFMailComposeResultFailed:
            debug(@"Fail");
            break;
            case MFMailComposeResultSent:
            debug(@"Sent");
            break;
            
        default:
            break;
    }
    
    [[[[UIApplication sharedApplication] keyWindow] rootViewController] dismissViewControllerAnimated:YES completion:^{
    }];
    [mailer dismissViewControllerAnimated:YES completion:nil];
    self.hidden = NO;

}

- (void)messageComposeViewController:(MFMessageComposeViewController *)controller didFinishWithResult:(MessageComposeResult)result;
{
    switch (result) {
        case MessageComposeResultCancelled:
            debug(@"Cancel");
            break;
            
            case MessageComposeResultFailed:
            debug(@"Fail");
            break;
            
            case MessageComposeResultSent:
            debug(@"Sent");
            break;
            
        default:
            break;
    }
//    [[[[UIApplication sharedApplication] keyWindow] rootViewController] dismissViewControllerAnimated:YES completion:^{
//        self.hidden = NO;
//    }];
    [controller dismissViewControllerAnimated:YES completion:nil];
    self.hidden = NO;
    
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex
{
    if (alertView.tag == 1) {
        if (buttonIndex == 1) {
            UIDevice *devide = [UIDevice currentDevice];
            debug(@"%@",[devide model]);
            if ([[devide model] isEqualToString:@"iPhone"]) {
                [[UIApplication sharedApplication] openURL:[NSURL URLWithString:[NSString stringWithFormat:@"tel:%@",_restaurantObj.phone]]];
            }
            else
            {
                [CommonHelpers showInfoAlertWithTitle:APP_NAME message:@"Your devide doesn't support this function." delegate:nil tag:1];
            }

        }
    }
    else if (alertView.tag ==2)
    {
        if (buttonIndex == 1) {
//            debug(@"code share directions here");
            
            if ([CommonHelpers isiOS6]) {
                CLLocationCoordinate2D coords =
                CLLocationCoordinate2DMake(_restaurantObj.lattitude, _restaurantObj.longtitude);
                
             NSDictionary *address = @{
                (NSString *)kABPersonAddressStreetKey: _restaurantObj.address
                };
                        
                MKPlacemark *place = [[MKPlacemark alloc]
                                      initWithCoordinate:coords addressDictionary:address];
                MKMapItem *mapItem = [[MKMapItem alloc] initWithPlacemark:place];
                [mapItem openInMapsWithLaunchOptions:nil];
            }
            else
            {
                [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"http://maps.google.com?q=New+York"]];
            }
         
           
            
            
        
            
        }
    }
    else
    {
        
    }
}

@end
