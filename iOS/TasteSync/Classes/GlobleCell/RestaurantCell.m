//
//  RestaurantCell2.m
//  TasteSync
//
//  Created by Victor on 12/24/12.
//  Copyright (c) 2012 Mobioneer. All rights reserved.
//

#import "RestaurantCell.h"
#import "CommonHelpers.h"


@interface RestaurantCell()
{
    __weak IBOutlet UILabel *lbName,*lbYourRate, *lbNameCheckin;
    __weak IBOutlet UILabel *lbDetail;
    __weak IBOutlet UIButton *btDeal;
    __weak IBOutlet UIImageView *ivAvatar;
    __weak IBOutlet UIImageView *nextImage;
    
    
    RateCustom *rateCustom;
    RestaurantObj *restaurantObj;
}

//- (IBAction)actionDeal:(id)sender;

@end

@implementation RestaurantCell
@synthesize delegate=_delegate;

# pragma mark - public's method

- (void) initForView :(RestaurantObj *) obj
{
    restaurantObj = obj;
    debug(@"initForView obj.name -> %@, rate: %f",obj.name, obj.rates);
    lbName.text = obj.name;
    lbDetail.text = [CommonHelpers getInformationRestaurant:obj];
    if (obj.rates != 0) {
        CGSize labelHeight = CGSizeMake(0, [self getTextHeight]);
        lbName.frame = CGRectMake(lbName.frame.origin.x, lbName.frame.origin.y, lbName.frame.size.width, labelHeight.height + 1);
        lbDetail.frame = CGRectMake(lbDetail.frame.origin.x, 4 + labelHeight.height, lbDetail.frame.size.width, lbDetail.frame.size.height);
        rateCustom = [[RateCustom alloc] initWithFrame:CGRectMake(20, 22 + labelHeight.height, 120, 20)];
        [nextImage setFrame:CGRectMake(nextImage.frame.origin.x, (78 - nextImage.frame.size.height)/2, nextImage.frame.size.width, nextImage.frame.size.height)];
        [rateCustom setRateMedium:obj.rates];
        [self addSubview:rateCustom];
        rateCustom.allowedRate = NO;
    }
    else
    {
        if (self.isJustName) {
            lbName.frame = CGRectMake(lbName.frame.origin.x, 16, lbName.frame.size.width, lbName.frame.size.height);
            nextImage.frame = CGRectMake(nextImage.frame.origin.x, 15, nextImage.frame.size.width, nextImage.frame.size.height);
            self.frame = CGRectMake(self.frame.origin.x, self.frame.origin.y, self.frame.size.width, 52);
            lbDetail.hidden = YES;
            //[rateCustom removeFromSuperview];
        }
        else
        {
            lbDetail.hidden = NO;
            lbName.frame = CGRectMake(lbName.frame.origin.x, 19, lbName.frame.size.width, lbName.frame.size.height);
            lbDetail.frame = CGRectMake(lbDetail.frame.origin.x, 37, lbDetail.frame.size.width, lbDetail.frame.size.height);
            //lbDetail.hidden = NO;
            //[rateCustom removeFromSuperview];
        }
        
    }
    
    
//    if (obj.isDeal) {
//        btDeal.hidden = NO;
//    }
//    else
    {
        btDeal.hidden = YES;
    }
    if (obj.isCheckin) {
        ivAvatar.hidden = NO;
        lbNameCheckin.hidden = NO;
    }
    else
    {
        ivAvatar.hidden = YES;
        lbNameCheckin.hidden = YES;
    }
}

//- (IBAction)actionDeal:(id)sender
//{
//    [[[CommonHelpers appDelegate] tabbarBaseVC] actionDeal:restaurantObj];
//}
-(CGFloat)getHeight:(RestaurantObj *) obj
{
    if (self.isJustName) {
        return 52;
    }
    else
    {
        
        return 57 + [self getTextHeight];
        
    }
}

-(CGFloat)getTextHeight
{
    CGSize labelHeight;
    
    //Label text
    NSString *aLabelTextString = @"";
    aLabelTextString = lbName.text;
    UIFont *aLabelFont = lbName.font;
    CGFloat aLabelSizeWidth = lbName.frame.size.width;
    if (SYSTEM_VERSION_LESS_THAN(iOS7_0)) {
        labelHeight = [aLabelTextString sizeWithFont:aLabelFont
                                   constrainedToSize:CGSizeMake(aLabelSizeWidth, MAXFLOAT)
                                       lineBreakMode:NSLineBreakByWordWrapping];
    }
    else if (SYSTEM_VERSION_GREATER_THAN_OR_EQUAL_TO(iOS7_0)) {
        labelHeight = [aLabelTextString boundingRectWithSize:CGSizeMake(aLabelSizeWidth, MAXFLOAT)
                                                     options:NSStringDrawingUsesLineFragmentOrigin
                                                  attributes:@{
                                                               NSFontAttributeName : aLabelFont
                                                               }
                                                     context:nil].size;
    }
    
    return labelHeight.height;
}

@end
